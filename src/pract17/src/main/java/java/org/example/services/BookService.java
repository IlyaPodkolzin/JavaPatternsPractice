package java.org.example.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.org.example.dto.BookDto;
import java.org.example.models.Book;
import java.org.example.repositories.BookRepository;
import java.org.example.repositories.BookRepositoryCustom;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final BookRepositoryCustom repositoryCustom;

    public List<Book> getAllBooks() {
        return repository.getAllBy().orElseThrow();
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public Integer deleteBookById(Long id) {
        return repository.deleteBookById(id).orElseThrow();
    }

    public List<BookDto> findByFilter(Book book) {
        return repositoryCustom
                .findBooksByCriteria(
                        book.getName(),
                        book.getCreationDate(),
                        book.getAuthorId()
                )
                .stream()
                .map(Book::toDto)
                .toList();
    }
}
