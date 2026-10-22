package prakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
