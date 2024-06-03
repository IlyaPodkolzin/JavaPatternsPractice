package java.org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.org.example.models.Book;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    private EntityManager entityManager;

    @Override
    public List<Book> findBooksByCriteria(String name, String creationDate, Long authorId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> book = cq.from(Book.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(cb.equal(book.get("name"), name));
        }
        if (creationDate != null) {
            predicates.add(cb.equal(book.get("creationDate"), creationDate));
        }
        if (authorId != null) {
            predicates.add(cb.equal(book.get("authorId"), authorId));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
