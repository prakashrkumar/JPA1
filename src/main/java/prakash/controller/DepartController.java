package prakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prakash.model.Department;
import prakash.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartController {
    DepartmentService departmentService;

    public  DepartController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping
    public ResponseEntity<String>createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("create successfully");
    }

    @PostMapping("/withStudent")
    public ResponseEntity<String>createDepartment(@RequestBody Department department, @RequestParam String studentName){
        departmentService.createDepartment(department,studentName);
        return ResponseEntity.ok("create successfully");
    }
}
