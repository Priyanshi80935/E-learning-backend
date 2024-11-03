package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.CourseDTO;
import com.tech.service.CourseService;

@RestController // @WebServlet("/api/course") like
@RequestMapping(value = "/api/course") // Endpoint - Connect from UI
public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping
	public List<CourseDTO> findAll() {
		return courseService.findAll();
	}

	@PostMapping
	public CourseDTO save(@RequestBody CourseDTO course) {
		return courseService.save(course);
	}

	@GetMapping("top-course")
	public List<CourseDTO> topCourse() {
		return courseService.topCourse();
	}
}
