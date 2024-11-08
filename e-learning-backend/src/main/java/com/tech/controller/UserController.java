package com.tech.controller;

import com.tech.dto.ApplicationUserDTO;
import com.tech.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/register")
public class UserController {
    @Autowired
    private ApplicationUserService applicationUserService;

    @PostMapping("/student")
    public ApplicationUserDTO saveStudent(@RequestBody ApplicationUserDTO applicationUserDTO) {
        return applicationUserService.saveStudent(applicationUserDTO);
    }
}
