package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.LectureDTO;
import com.tech.service.LectureService;

@RestController
@RequestMapping(value = "/api/lecture") // Endpoint - Connect from UI
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @GetMapping
    public List<LectureDTO> findAll() {
        return lectureService.findAll();
    }

    @PostMapping
    public LectureDTO save(@RequestBody LectureDTO lecture) {
        return lectureService.save(lecture);
    }
}
