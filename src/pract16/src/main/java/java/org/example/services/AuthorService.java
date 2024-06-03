package java.org.example.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.org.example.models.Author;
import java.org.example.repositories.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.getAllBy().orElseThrow();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public Integer deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id).orElseThrow();
    }
}
