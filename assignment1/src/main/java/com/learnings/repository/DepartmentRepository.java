package com.learnings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnings.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
