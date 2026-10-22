package prakash.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import prakash.model.Department;
import prakash.repository.DepartmentRepository;


@Service

public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public  DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }
    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }

}
