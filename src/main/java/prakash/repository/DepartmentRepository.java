package prakash.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import prakash.model.Department;

@Repository
public class DepartmentRepository {

    private EntityManager entityManager;
    public DepartmentRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public  void save(Department department){
        entityManager.persist(department);
    }
    public  Department  getDepartmentById(Long id){
      return   entityManager.find(Department.class,id);
    }

}
