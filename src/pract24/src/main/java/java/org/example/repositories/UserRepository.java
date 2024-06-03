package java.org.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.org.example.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
