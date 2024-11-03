package com.tech.service;

import com.tech.dto.ModuleDTO;
import com.tech.entity.Course;
import com.tech.entity.ModuleEntity;
import com.tech.mapper.ModuleMapper;
import com.tech.repository.CourseRepository;
import com.tech.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private CourseRepository courseRepository;

    public ModuleDTO save(ModuleDTO moduleDTO) {
        Long courseId = moduleDTO.getCourseId();
        Course course = courseRepository.findById(courseId).get();

        ModuleEntity entity = moduleMapper.toEntity(moduleDTO);
        ModuleEntity newEntity = moduleRepository.save(entity);
        course.getModules().add(newEntity);
        courseRepository.save(course);

        return moduleMapper.toDTO(newEntity);
    }

    public List<ModuleDTO> findModuleByCourseId(Long courseId) {
        List<ModuleEntity> modules = courseRepository.findById(courseId).get().getModules();
        List<ModuleDTO> moduleDTOS = new ArrayList<>();

        for (ModuleEntity mo : modules) {
            moduleDTOS.add(moduleMapper.toDTO(mo));
        }
        return moduleDTOS;
    }
}
