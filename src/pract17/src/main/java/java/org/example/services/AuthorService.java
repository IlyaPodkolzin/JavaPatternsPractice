package java.org.example.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.org.example.dto.AuthorDto;
import java.org.example.models.Author;
import java.org.example.repositories.AuthorRepository;
import java.org.example.repositories.AuthorRepositoryImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorRepositoryImpl authorRepositoryCustom;

    public List<Author> getAllAuthors() {
        return authorRepository.getAllBy().orElseThrow();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public Integer deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id).orElseThrow();
    }

    public List<AuthorDto> findByFilter(Author author) {
        return authorRepositoryCustom
                .findAuthorsByCriteria(
                        author.getFirstName(),
                        author.getLastName(),
                        author.getMiddleName(),
                        author.getBirthDate()
                )
                .stream()
                .map(Author::toDto)
                .toList();
    }
}
