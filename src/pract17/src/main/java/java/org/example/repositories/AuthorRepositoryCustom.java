package java.org.example.repositories;

import java.org.example.models.Author;

import java.util.List;

public interface AuthorRepositoryCustom {
    List<Author> findAuthorsByCriteria(String firstName, String lastName, String middleName, String birthDate);
}
