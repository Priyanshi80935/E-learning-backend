package com.tech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @WebServlet("/api/course") like
@RequestMapping(value ="/api/course") //Endpoint - Connect from UI
public class CourseController {
	
	@GetMapping
	public String index() {
		return "BOOT Started";
	}
}
