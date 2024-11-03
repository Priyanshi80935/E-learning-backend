package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("my")
	public List<CourseDTO> myCourse() {
		return courseService.myCourse();
	}

	@GetMapping("by-id/{courseId}")
	public CourseDTO findById(@PathVariable Long courseId) {
		return courseService.findById(courseId);
	}
}
