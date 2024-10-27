package com.tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.CourseDTO;
import com.tech.entity.Course;
import com.tech.mapper.CourseMapper;
import com.tech.repository.CourseRepository;

@Service  //Springboot will crearte a object
public class CourseService {
	@Autowired //Springboot will provide this object
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseMapper courseMapper;

	public CourseDTO save(CourseDTO courseDTO) {
		Course entity = courseMapper.toEntity(courseDTO);
		Course save = courseRepository.save(entity); //It will take entity and save in dstabse and return the saved data
		return courseMapper.toDTO(save);
	}

	public List<CourseDTO> findAll() {
		List<Course> all = courseRepository.findAll();
		List<CourseDTO> courseDTOs = new ArrayList<>();
		//Satya task
		for(Course course : all) {
			courseDTOs.add(courseMapper.toDTO(course));
		}
		return courseDTOs;
	}

}
