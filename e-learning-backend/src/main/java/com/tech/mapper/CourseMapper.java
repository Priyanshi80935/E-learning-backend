package com.tech.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tech.dto.CourseDTO;
import com.tech.dto.ModuleDTO;
import com.tech.entity.Course;
import com.tech.entity.Lecture;
import com.tech.entity.ModuleEntity;

@Component //Springboot will crearte a object
public class CourseMapper {
	@Autowired
	private ModuleMapper moduleMapper;
	
	public CourseDTO toDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(course.getId());
		courseDTO.setName(course.getName());
		courseDTO.setDescription(course.getDescription());
		courseDTO.setDuration(course.getDescription());
		courseDTO.setImg(course.getImg());
		if(course.getLecture() != null) {
			courseDTO.setLectureId(course.getLecture().getId());
			courseDTO.setLectureName(course.getLecture().getName());
		}
		courseDTO.setNoOfStudents(course.getNoOfStudents());
		courseDTO.setPrice(course.getPrice());
		courseDTO.setRatingCount(course.getRatingCount());
		courseDTO.setRating(course.getRating());
		
		List<ModuleEntity> modules = course.getModules();
		List<ModuleDTO> moduleDTOs = new ArrayList<>();
		if(modules != null) {
			for(ModuleEntity module : modules) {
				ModuleDTO dto = moduleMapper.toDTO(module);
				moduleDTOs.add(dto);
			}
		}
		courseDTO.setModules(moduleDTOs);
		
		return courseDTO;
	}
	
	public Course toEntity(CourseDTO courseDTO) {
		Course course = new Course();
		course.setId(courseDTO.getId());
		course.setName(courseDTO.getName());
		course.setDescription(courseDTO.getDescription());
		course.setDuration(courseDTO.getDescription());
		course.setImg(courseDTO.getImg());
		if(courseDTO.getLectureId() != null) {
			Long lectureId = courseDTO.getLectureId();
			Lecture lecture = new Lecture();
			lecture.setId(lectureId);
			course.setLecture(lecture);
		}
		
		course.setNoOfStudents(courseDTO.getNoOfStudents());
		course.setPrice(courseDTO.getPrice());
		course.setRatingCount(courseDTO.getRatingCount());
		course.setRating(courseDTO.getRating());
		
		List<ModuleDTO> moduleDTOs = courseDTO.getModules();
		List<ModuleEntity> modules = new ArrayList<>();
		
		if(moduleDTOs != null) {
			for(ModuleDTO moduleDTO : moduleDTOs) {
				ModuleEntity entity = moduleMapper.toEntity(moduleDTO);
				modules.add(entity);
			}
		}
		course.setModules(modules);
		return course;
	}
}
