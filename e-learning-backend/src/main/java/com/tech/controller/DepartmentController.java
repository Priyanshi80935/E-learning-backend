package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.DepartmentDTO;
import com.tech.service.DepartmentService;

@RestController
@RequestMapping(value = "/api/department") // Base endpoint for Department API
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public List<DepartmentDTO> findAll() {
        return departmentService.findAll();
    }

    @PostMapping
    public DepartmentDTO save(@RequestBody DepartmentDTO department) {
        return departmentService.save(department);
    }
}
