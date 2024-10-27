package com.tech.mapper;

import org.springframework.stereotype.Component;

import com.tech.dto.CourseDTO;
import com.tech.entity.Course;

@Component //Springboot will crearte a object
public class CourseMapper {
	public CourseDTO toDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(course.getId());
		courseDTO.setName(course.getName());
		courseDTO.setDescription(course.getDescription());
		courseDTO.setDuration(course.getDescription());
		courseDTO.setImg(course.getImg());
		courseDTO.setLecture(course.getLecture());
		courseDTO.setNoOfStudents(course.getNoOfStudents());
		courseDTO.setPrice(course.getPrice());
		courseDTO.setRatingCount(course.getRatingCount());
		courseDTO.setRating(course.getRating());
		return courseDTO;
	}
	
	public Course toEntity(CourseDTO courseDTO) {
		Course course = new Course();
		course.setId(courseDTO.getId());
		course.setName(courseDTO.getName());
		course.setDescription(courseDTO.getDescription());
		course.setDuration(courseDTO.getDescription());
		course.setImg(courseDTO.getImg());
		course.setLecture(courseDTO.getLecture());
		course.setNoOfStudents(courseDTO.getNoOfStudents());
		course.setPrice(courseDTO.getPrice());
		course.setRatingCount(courseDTO.getRatingCount());
		course.setRating(courseDTO.getRating());
		return course;
	}
}