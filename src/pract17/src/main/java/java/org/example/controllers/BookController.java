package java.org.example.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.org.example.dto.BookDto;
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
    public List<BookDto> getBooks() {
        return service.getAllBooks().stream().map(Book::toDto).toList();
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

    @GetMapping("/filter")
    @ResponseBody
    public List<BookDto> getFilter(@RequestBody Book book) {
        return service.findByFilter(book);
    }
}
