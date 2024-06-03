package java.org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.org.example.dto.AuthorDto;
import java.org.example.models.Book;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BackupService {

    private final AuthorService authorService;

    private final BookService bookService;

    @Scheduled(fixedRate = 1800000)
    @Async
    public void backup() {
        cleanBackupFolder();
        backupAuthors();
        backupBooks();
        log.info("Backup complete.");
    }

    private static void cleanBackupFolder() {
        File folder = new File("src/main/resources/backup");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (!f.delete()) {
                    log.error("Failed to delete file {}", f);
                }
            }
        }
    }

    private void backupAuthors() {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/backup/author.txt", StandardCharsets.UTF_8);
            writer.print("");
            List<AuthorDto> authors = authorService.getAllAuthors();
            for (AuthorDto author : authors) {
                writer.append(author.toString()).append("\n");
            }
            writer.close();
            log.info("Authors backup complete.");
        } catch (Exception e) {
            log.error("Failed to backup authors.", e);
        }
    }

    private void backupBooks() {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/backup/book.txt", StandardCharsets.UTF_8);
            writer.print("");
            List<Book> books = bookService.getAllBooks();
            for (Book book : books) {
                writer.append(book.toDto().toString()).append("\n");
            }
            writer.close();
            log.info("Books backup complete.");
        } catch (Exception e) {
            log.error("Failed to backup books.", e);
        }
    }
}
