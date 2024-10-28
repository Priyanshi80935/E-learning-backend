package com.tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.DepartmentDTO;
import com.tech.entity.Department;
import com.tech.mapper.DepartmentMapper;
import com.tech.repository.DepartmentRepository;

@Service  // Spring will create an object of this service
public class DepartmentService {
    @Autowired // Spring will inject the DepartmentRepository dependency
    private DepartmentRepository departmentRepository;
    
    @Autowired // Spring will inject the DepartmentMapper dependency
    private DepartmentMapper departmentMapper;

    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        Department entity = departmentMapper.toEntity(departmentDTO);
        Department savedEntity = departmentRepository.save(entity); // Saves entity to the database
        return departmentMapper.toDTO(savedEntity);
    }

    public List<DepartmentDTO> findAll() {
        List<Department> allDepartments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        
        // Converting each Department entity to DepartmentDTO
        for (Department department : allDepartments) {
            departmentDTOs.add(departmentMapper.toDTO(department));
        }
        return departmentDTOs;
    }
}
