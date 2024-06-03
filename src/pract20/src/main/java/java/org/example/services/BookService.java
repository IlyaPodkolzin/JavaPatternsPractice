package java.org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.org.example.dto.BookDto;
import java.org.example.models.Book;
import java.org.example.repositories.BookRepository;

import java.util.List;

import static java.org.example.specifications.BookSpecification.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository repository;

    public List<Book> getAllBooks() {
        log.info("Get all books: Start");

        var res = repository.getAllBy().orElseThrow();

        log.info("Get all books: Finish");
        return res;
    }

    public void addBook(Book book) {
        log.info("Add book: Start");
        log.info("Book: " + book.toString());

        repository.save(book);
        log.info("Add book: Finish");
    }

    public Integer deleteBookById(Long id) {
        log.info("Delete book: Start");
        log.info("Book id: " + id);

        var res =  repository.deleteBookById(id).orElseThrow();

        log.info("Delete book: Finish");
        return res;
    }

    public List<BookDto> findByFilter(Book book) {
        log.info("Get books with filters: Start");

        Specification<Book> filters = Specification
                .where(book.getName() == null ? null : nameLike(book.getName()))
                .and(book.getCreationDate() == null ? null : creationDateLike(book.getCreationDate()))
                .and(book.getAuthorId() == null ? null : authorIdIs(book.getAuthorId()));

        var res = repository
                .findAll(filters)
                .stream()
                .map(Book::toDto)
                .toList();

        log.info("Get books with filters: End");
        return res;
    }
}
