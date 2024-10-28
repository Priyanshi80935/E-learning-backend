package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.VideoDTO;
import com.tech.service.VideoService;

@RestController
@RequestMapping(value = "/api/video")
public class VideoController {
	@Autowired
	private VideoService videoService;
	
	
	@PostMapping
	public VideoDTO save(@RequestBody VideoDTO  videoDTO) {
		
		return videoService.save(videoDTO);
	}
}
