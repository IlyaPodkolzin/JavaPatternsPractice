package java.org.example.repositories;

import java.org.example.models.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findBooksByCriteria(String name, String creationDate, Long authorId);
}
