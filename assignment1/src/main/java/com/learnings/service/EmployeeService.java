package com.learnings.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnings.entity.Department;
import com.learnings.entity.Employee;
import com.learnings.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    public List<Employee> findAll() {
	        return employeeRepository.findAll();
	    }

	    public Optional<Employee> findById(Long id) {
	        return employeeRepository.findById(id);
	    }

	    public List<Employee> findByDepartmentId(Long departmentId) {
	        return employeeRepository.findByDepartmentId(departmentId);
	    }

	    public Employee save(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    public void deleteById(Long id) {
	        employeeRepository.deleteById(id);
	    }

	    public List<Employee> findAllWithDepartments() {
	        return employeeRepository.findAll().stream().map(employee -> {
	            Department department = employee.getDepartment();
	            employee.setDepartment(department);
	            return employee;
	        }).collect(Collectors.toList());
	    }

}
