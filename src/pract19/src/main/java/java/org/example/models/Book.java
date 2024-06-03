package java.org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.org.example.dto.BookDto;

import java.util.Objects;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private String creationDate;
    @Column(name = "author_id")
    private Long authorId;
    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(creationDate, book.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate);
    }

    public BookDto toDto() {
        return new BookDto(id, name, creationDate, author.toDto());
    }
}
