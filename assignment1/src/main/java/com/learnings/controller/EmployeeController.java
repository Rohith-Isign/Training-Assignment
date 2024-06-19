package com.learnings.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.entity.Employee;
import com.learnings.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Employee> findById(@PathVariable Long id) {
		return employeeService.findById(id);
	}

	@GetMapping("/department/{departmentId}")
	public List<Employee> findByDepartmentId(@PathVariable Long departmentId) {
		return employeeService.findByDepartmentId(departmentId);
	}

	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		employeeService.deleteById(id);
	}

	@GetMapping("/with-departments")
	public List<Employee> findAllWithDepartments() {
		return employeeService.findAllWithDepartments();
	}
	
	 @PutMapping("/{id}")
	    public Employee update(@PathVariable Long id, @RequestBody Employee employeeDetails) {
	        Optional<Employee> optionalEmployee = employeeService.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee employee = optionalEmployee.get();
	            employee.setFirstName(employeeDetails.getFirstName());
	            employee.setLastName(employeeDetails.getLastName());
	            employee.setDepartment(employeeDetails.getDepartment());
	            employee.setUpdatedByUsername(employeeDetails.getUpdatedByUsername());
	            return employeeService.save(employee);
	        }
	        return null;
	    }


}
