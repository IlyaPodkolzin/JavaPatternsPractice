package java.org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.org.example.models.Author;
import java.org.example.repositories.AuthorRepository;
import java.org.example.services.AuthorService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;

    @Captor
    ArgumentCaptor<Author> captor;

    @Test
    void getAllAuthors() {
        Author author = new Author();
        author.setFirstName("Vasya");
        Author author2 = new Author();
        author2.setFirstName("Dima");


        Mockito.when(authorRepository.getAllBy()).thenReturn(Optional.of(List.of(author, author2)));
        AuthorService authorService = new AuthorService(authorRepository);

        assertEquals(2, authorService.getAllAuthors().size());
        assertEquals("Vasya", authorService.getAllAuthors().get(0).getFirstName());
    }

    @Test
    void addAuthor() {
        Author author = new Author();
        author.setFirstName("Vitya");

        AuthorService userService = new AuthorService(authorRepository);
        userService.addAuthor(author);

        Mockito.verify(authorRepository).save(captor.capture());
        Author captured = captor.getValue();

        assertEquals("Vitya", captured.getFirstName());
    }
}
