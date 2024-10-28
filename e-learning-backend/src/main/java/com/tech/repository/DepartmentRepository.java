package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tech.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // save() for inserting or updating records
    // findAll() for retrieving all records
}
