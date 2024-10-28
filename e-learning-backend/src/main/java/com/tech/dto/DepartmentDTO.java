package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private long id;
    private String name;
    private String description;
    private String head;
    private int numberOfCourses;
    private int numberOfStudents;
    private String location;
}
