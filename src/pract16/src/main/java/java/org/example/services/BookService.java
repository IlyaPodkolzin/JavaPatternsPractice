package java.org.example.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.org.example.models.Book;
import java.org.example.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.getAllBy().orElseThrow();
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public Integer deleteBookById(Long id) {
        return repository.deleteBookById(id).orElseThrow();
    }
}
