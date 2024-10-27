package com.tech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.Course;

@RestController // @WebServlet("/api/course") like 
@RequestMapping(value ="/api/course") //Endpoint - Connect from UI
public class CourseController {
	
	List<Course> courses = new ArrayList<>();
	
	@GetMapping
	public List<Course> index() {
		return courses;

	}
	
	@PostMapping
	public void save(@RequestBody Course course) {
		courses.add(course);
	}
}
