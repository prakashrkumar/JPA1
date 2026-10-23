package prakash.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import prakash.model.Department;
import prakash.model.Student;
import prakash.repository.DepartmentRepository;
import prakash.repository.StudentRepository;


@Service

public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department, String studentName) {
        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);
        department.getStudents().add(student);
        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
