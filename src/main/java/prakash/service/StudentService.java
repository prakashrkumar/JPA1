package prakash.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
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
        department.getStudents().add(student);
studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student,@RequestParam  String deptName){
        Department department=new Department();
        department.setName(deptName);
        student.setDepartment(department);
        department.getStudents().add(student);
        departmentRepository.save(department);

        studentRepository.save(student);
    }
}
