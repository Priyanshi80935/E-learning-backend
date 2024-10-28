package com.tech.mapper;

import org.springframework.stereotype.Component;

import com.tech.dto.DepartmentDTO;
import com.tech.entity.Department;

@Component // Spring will create an object of this 
public class DepartmentMapper {
    
    public DepartmentDTO toDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        departmentDTO.setDescription(department.getDescription());
        departmentDTO.setHead(department.getHead());
        departmentDTO.setNumberOfCourses(department.getNumberOfCourses());
        departmentDTO.setNumberOfStudents(department.getNumberOfStudents());
        departmentDTO.setLocation(department.getLocation());
        return departmentDTO;
    }
    
    public Department toEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        department.setHead(departmentDTO.getHead());
        department.setNumberOfCourses(departmentDTO.getNumberOfCourses());
        department.setNumberOfStudents(departmentDTO.getNumberOfStudents());
        department.setLocation(departmentDTO.getLocation());
        return department;
    }
}
