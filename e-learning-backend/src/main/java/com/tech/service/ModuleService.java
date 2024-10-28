package com.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.CourseDTO;
import com.tech.dto.ModuleDTO;
import com.tech.entity.Course;
import com.tech.entity.ModuleEntity;
import com.tech.mapper.ModuleMapper;
import com.tech.repository.CourseRepository;
import com.tech.repository.ModuleRepository;

@Service
public class ModuleService {
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private CourseRepository courseRepository;

	public ModuleDTO save(ModuleDTO moduleDTO) {
		CourseDTO courseDTO = moduleDTO.getCourseDTO();
		Long courseid = courseDTO.getId();
		Course course = courseRepository.findById(courseid).get();
		
		ModuleEntity entity = moduleMapper.toEntity(moduleDTO);
		ModuleEntity newEntity = moduleRepository.save(entity);
		course.getModules().add(newEntity);
		courseRepository.save(course);
		
		return  moduleMapper.toDTO(newEntity);
	}

	public List<ModuleDTO> findModuleByCourseId(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}
}
