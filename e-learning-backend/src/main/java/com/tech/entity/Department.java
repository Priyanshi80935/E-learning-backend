package com.tech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tbl_department") // Updated table name for Department
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name", length = 100, nullable = false) // Updated column name
    private String name;

    private String description;
    private String head; // Name of the department head
    private int numberOfCourses; // Number of courses offered
    private int numberOfStudents; // Number of students in the department
    private String location; // Location of the department

    
}
