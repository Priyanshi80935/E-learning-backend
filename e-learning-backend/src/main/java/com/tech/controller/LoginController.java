package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.LoginDTO;
import com.tech.service.LoginService;

@RestController
@RequestMapping(value = "/api/login") // Base endpoint for Login API
public class LoginController {

    @Autowired // Spring will inject the LoginService dependency
    private LoginService loginService;

    // Endpoint for user login
    @PostMapping
    public LoginDTO login(@RequestBody LoginDTO loginDto) {
        return loginService.authenticate(loginDto);
    }

    // Endpoint to retrieve all login attempts
    @GetMapping("/all")
    public List<LoginDTO> findAllLogins() {
        return loginService.findAll();
    }
}
