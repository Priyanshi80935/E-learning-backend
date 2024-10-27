package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private double rating;
    private String img;
    private String duration;
    private int noOfStudents;
    private String lecture;
    private int ratingCount;
}
