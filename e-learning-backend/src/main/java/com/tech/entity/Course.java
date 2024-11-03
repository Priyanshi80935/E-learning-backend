package com.tech.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tbl_course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "course_name", length = 100, nullable = true)
    private String name;
	
    private String description;
    private double price;
    private double rating;
    private String img;
    private String duration;
    private int noOfStudents;
    private int ratingCount;
    
    @OneToMany
    List<ModuleEntity> modules = new ArrayList<>();
    
    @ManyToOne
    private Lecture lecture;
    
    
}
