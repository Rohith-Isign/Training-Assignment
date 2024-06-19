package com.learnings.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.entity.Department;
import com.learnings.service.DepartmentService;
import com.learnings.service.EmployeeService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @PostMapping("/save")
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);
    }

    @GetMapping("/with-employees/{id}")
    public Optional<Department> findDepartmentWithEmployees(@PathVariable Long id) {
        return departmentService.findById(id).map(department -> {
            department.setEmployees(employeeService.findByDepartmentId(id));
            return department;
        });
    }
    
    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department departmentDetails) {
        Optional<Department> optionalDepartment = departmentService.findById(id);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setName(departmentDetails.getName());
            department.setUpdatedByUsername(departmentDetails.getUpdatedByUsername());
            return departmentService.save(department);
        }
        return null; 
    }

}
