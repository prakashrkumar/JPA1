package prakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prakash.model.Student;
import prakash.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/{deptId}")
    public ResponseEntity<String>createStudent(@RequestBody Student student,@PathVariable Long deptId){
        studentService.createStudent(student,deptId);
        return ResponseEntity.ok("DONE");
    }
}
