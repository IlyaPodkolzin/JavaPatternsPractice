package java.org.example.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.org.example.dto.AuthorDto;
import java.org.example.models.Author;
import java.org.example.repositories.AuthorRepository;

import java.util.List;

import static java.org.example.specifications.AuthorSpecification.*;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<AuthorDto> getAllAuthors() {
        return authorRepository.getAllBy().orElseThrow().stream().map(Author::toDto).toList();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public Integer deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id).orElseThrow();
    }

    public List<AuthorDto> findByFilter(Author author) {
        Specification<Author> filters = Specification
                .where(author.getFirstName() == null ? null : firstNameLike(author.getFirstName()))
                .and(author.getLastName() == null ? null : lastNameLike(author.getLastName()))
                .and(author.getMiddleName() == null ? null : middleNameLike(author.getMiddleName()))
                .and(author.getBirthDate() == null ? null : birthDateLike(author.getBirthDate()));

        return authorRepository
                .findAll(filters)
                .stream()
                .map(Author::toDto)
                .toList();
    }
}
