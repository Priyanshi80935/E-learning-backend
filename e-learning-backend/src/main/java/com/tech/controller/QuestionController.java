package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tech.dto.QuestionDTO;
import com.tech.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<QuestionDTO> findAll() {
        return questionService.findAll();
    }

    @PostMapping
    public QuestionDTO save(@RequestBody QuestionDTO questionDTO) {
        return questionService.save(questionDTO);
    }
}
