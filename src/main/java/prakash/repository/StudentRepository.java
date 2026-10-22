package prakash.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import prakash.model.Student;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

public void save(Student student){
    entityManager.persist(student);
}
}
