package java.org.example.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.org.example.dto.AuthorDto;
import java.org.example.models.Author;
import java.org.example.services.AuthorService;
import java.org.example.services.EmailService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/authors")
public class AuthorController {

    private final AuthorService service;
    private final EmailService emailService;

    @GetMapping
    @ResponseBody
    public List<AuthorDto> getAuthors() {
        return service.getAllAuthors();
    }

    @PostMapping
    @ResponseBody
    public Author addAuthor(
            @RequestBody Author author
    ) {
        service.addAuthor(author);
        emailService.sendEmail("gribkovalexander@gmail.com", "Author add!", "Author add:\n" + author);
        return author;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id) {
        return "Count: " + service.deleteAuthorById(id);
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<AuthorDto> getFilter(@RequestBody Author author) {
        return service.findByFilter(author);
    }
}
