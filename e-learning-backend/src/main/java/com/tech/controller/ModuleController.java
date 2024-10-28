package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.ModuleDTO;
import com.tech.service.ModuleService;

@RestController
@RequestMapping(value = "/api/module")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	
	@PostMapping
	public ModuleDTO save(@RequestBody ModuleDTO moduleDTO) {
		return moduleService.save(moduleDTO);
	}
	
	@GetMapping(value = "{courseId}")
	public List<ModuleDTO> findModuleByCourseId(@PathVariable Long courseId) {
		return moduleService.findModuleByCourseId(courseId);
	}
}
