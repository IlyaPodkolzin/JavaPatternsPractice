package java.org.example.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.org.example.models.Book;
import java.org.example.services.BookService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/books")
public class BookController {
    private final BookService service;

    @GetMapping
    @ResponseBody
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    @PostMapping
    @ResponseBody
    public Book addBook(
            @RequestBody Book book
    ) {
        service.addBook(book);
        return book;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        return "Count: " + service.deleteBookById(id);
    }
}
