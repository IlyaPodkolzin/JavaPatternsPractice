package java.org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.org.example.models.Book;
import java.org.example.repositories.BookRepository;
import java.org.example.services.BookService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @Captor
    ArgumentCaptor<Book> captor;

    @Test
    void getAllAuthors() {
        Book book = new Book();
        book.setName("Vasya");
        Book book2 = new Book();
        book2.setName("Dima");


        Mockito.when(bookRepository.getAllBy()).thenReturn(Optional.of(List.of(book, book2)));
        BookService bookService = new BookService(bookRepository);

        assertEquals(2, bookService.getAllBooks().size());
        assertEquals("Vasya", bookService.getAllBooks().get(0).getName());
    }

    @Test
    void addAuthor() {
        Book book = new Book();
        book.setName("Vitya");

        BookService bookService = new BookService(bookRepository);
        bookService.addBook(book);

        Mockito.verify(bookRepository).save(captor.capture());
        Book captured = captor.getValue();

        assertEquals("Vitya", captured.getName());
    }
}
