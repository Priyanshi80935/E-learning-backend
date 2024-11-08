package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tech.dto.AnswerDTO;
import com.tech.service.AnswerService;

@RestController
@RequestMapping(value = "/api/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping
    public AnswerDTO save(@RequestBody AnswerDTO answerDTO) {
        return answerService.save(answerDTO);
    }
}
