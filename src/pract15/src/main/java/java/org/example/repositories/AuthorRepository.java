package java.org.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.org.example.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<List<Author>> getAllBy();

    Optional<Integer> deleteAuthorById(Long id);
}
