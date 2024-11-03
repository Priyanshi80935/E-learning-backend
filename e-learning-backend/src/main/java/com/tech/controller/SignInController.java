package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.SignInDTO;
import com.tech.service.SignInService;

@RestController
@RequestMapping(value = "/api/signin") // Base endpoint for SignIn API
public class SignInController {

    @Autowired // Spring will inject the SignInService dependency
    private SignInService signInService;

    // Endpoint for user sign-in
    @PostMapping
    public SignInDTO signIn(@RequestBody SignInDTO signInDto) {
        return signInService.save(signInDto);
    }

    // Endpoint to retrieve all sign-ins
    @GetMapping("/all")
    public List<SignInDTO> findAll() {
        return signInService.findAll();
    }
}
