package prakash.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import prakash.model.Department;
import prakash.model.Student;
import prakash.repository.DepartmentRepository;
import prakash.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository=departmentRepository;
    }
    @Transactional
    public void createStudent(Student student,Long deptId){
        Department department=departmentRepository.getDepartmentById(deptId);
        student .setDepartment(department);
studentRepository.save(student);
    }
}
