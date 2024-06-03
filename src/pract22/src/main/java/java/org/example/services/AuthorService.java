package java.org.example.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.org.example.dto.AuthorDto;
import java.org.example.models.Author;
import java.org.example.repositories.AuthorRepository;

import java.org.example.specifications.AuthorSpecification;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthorService {

    private final AuthorRepository repository;

    public List<AuthorDto> getAllAuthors() {
        log.info("Get all authors: Start");

        var res = repository.getAllBy().orElseThrow().stream().map(Author::toDto).toList();

        log.info("Get all authors: Finish");
        return res;
    }

    public void addAuthor(Author author) {
        log.info("Add author: Start");
        log.info("Author: {}", author.toString());

        repository.save(author);

        log.info("Add author: Finish");
    }

    public Integer deleteAuthorById(Long id) {
        log.info("Delete author: Start");
        log.info("Author id: {}", id);

        var res = repository.deleteAuthorById(id).orElseThrow();

        log.info("Delete author: Finish");
        return res;
    }

    public List<AuthorDto> findByFilter(Author author) {
        log.info("Get authors with filters: Start");

        Specification<Author> filters = Specification
                .where(author.getFirstName() == null ? null : AuthorSpecification.firstNameLike(author.getFirstName()))
                .and(author.getLastName() == null ? null : AuthorSpecification.lastNameLike(author.getLastName()))
                .and(author.getMiddleName() == null ? null : AuthorSpecification.middleNameLike(author.getMiddleName()))
                .and(author.getBirthDate() == null ? null : AuthorSpecification.birthDateLike(author.getBirthDate()));

        var res = repository
                .findAll(filters)
                .stream()
                .map(Author::toDto)
                .toList();

        log.info("Get authors with filters: End");
        return res;
    }
}
