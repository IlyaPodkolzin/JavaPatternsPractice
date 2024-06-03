package java.org.example.specifications;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import java.org.example.models.Book;

@NoArgsConstructor
public class BookSpecification {
    public static Specification<Book> nameLike(String nameLike) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + nameLike + "%");
    }

    public static Specification<Book> creationDateLike(String creationDateLike) {
        return (root, query, builder) -> builder.like(root.get("creationDate"), "%" + creationDateLike + "%");
    }

    public static Specification<Book> authorIdIs(Long authorIdLike) {
        return (root, query, builder) -> builder.equal(root.get("authorId"), authorIdLike);
    }
}
