package com.tech.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
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

    @Lob
    private String description;
    private double price;
    private double rating;

    @Lob
    private String img;
    private String duration;
    private int noOfStudents;
    private int ratingCount;
    
    @OneToMany
    List<ModuleEntity> modules = new ArrayList<>();
    
    @ManyToOne
    private Lecture lecture;
    
    
}
