package java.org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.org.example.models.Author;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {

    private EntityManager entityManager;

    @Override
    public List<Author> findAuthorsByCriteria(String firstName, String lastName, String middleName, String birthDate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);

        Root<Author> author = cq.from(Author.class);
        List<Predicate> predicates = new ArrayList<>();

        if (firstName != null) {
            predicates.add(cb.equal(author.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(cb.equal(author.get("lastName"), lastName));
        }
        if (middleName != null) {
            predicates.add(cb.equal(author.get("middleName"), middleName));
        }
        if (birthDate != null) {
            predicates.add(cb.equal(author.get("birthDate"), birthDate));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
