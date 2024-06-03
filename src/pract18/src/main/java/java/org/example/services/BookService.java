package java.org.example.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.org.example.dto.BookDto;
import java.org.example.models.Book;
import java.org.example.repositories.BookRepository;

import java.util.List;

import static java.org.example.specifications.BookSpecification.*;

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

    public List<BookDto> findByFilter(Book book) {
        Specification<Book> filters = Specification
                .where(book.getName() == null ? null : nameLike(book.getName()))
                .and(book.getCreationDate() == null ? null : creationDateLike(book.getCreationDate()))
                .and(book.getAuthorId() == null ? null : authorIdIs(book.getAuthorId()));

        return repository
                .findAll(filters)
                .stream()
                .map(Book::toDto)
                .toList();
    }
}
