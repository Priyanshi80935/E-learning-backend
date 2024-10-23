package com.tech.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.Course;

@RestController // @WebServlet("/api/course") like 
@RequestMapping(value ="/api/course") //Endpoint - Connect from UI
public class CourseController {
	
	@GetMapping
	public List<Course> index() {
		return Arrays.asList( new Course(1, "Angular", 
			        "Angular is a platform and framework for building single-page client applications using HTML and TypeScript.", 
			        100, 4, "images/angular.png", "2 months", 1000, "12", 103),
			        
			    new Course(2, "React", 
			        "React is a declarative, efficient, and flexible JavaScript library for building user interfaces.", 
			        200, 3, "images/react.png", "3 months", 2000, "15", 100),
			        
			    new Course(3, "Vue", 
			        "Vue.js is a progressive framework for building user interfaces.", 
			        150, 5, "images/vue.png", "2.5 months", 1500, "14", 100)
			);

	}
}
