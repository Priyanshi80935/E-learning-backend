package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tech.dto.VideoDTO;
import com.tech.service.VideoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/video")
public class VideoController {
	@Autowired
	private VideoService videoService;
	
	
	@PostMapping
	public VideoDTO save(@RequestBody VideoDTO  videoDTO) {
		
		return videoService.save(videoDTO);
	}

	@GetMapping(value = "{moduleId}")
	public List<VideoDTO> getVideosByModuleId(@PathVariable Long moduleId) {
		return videoService.getVideosByModuleId(moduleId);
	}

	@GetMapping(value = "find-by-id/{videoId}")
	public VideoDTO findById(@PathVariable Long videoId) {
		return videoService.findById(videoId);
	}
}
