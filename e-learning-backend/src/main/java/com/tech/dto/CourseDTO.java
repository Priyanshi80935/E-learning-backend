package com.tech.dto;

import java.util.ArrayList;
import java.util.List;

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
    private Long lectureId;
    private String lectureName;
    private int ratingCount;
    List<ModuleDTO> modules = new ArrayList<>();
}
