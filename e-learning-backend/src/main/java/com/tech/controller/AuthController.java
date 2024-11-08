package com.tech.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/authenticate")
public class AuthController {
    @PostMapping
    public boolean authenticate(@RequestHeader("Authorization") String authorizationHeader) {
       return true;
    }

}
