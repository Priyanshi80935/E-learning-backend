package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tech.dto.VideoDTO;
import com.tech.service.VideoService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/video")
public class VideoController {
	@Autowired
	private VideoService videoService;


	@PostMapping
	public VideoDTO save(
			@RequestPart("video") VideoDTO videoDTO,
			@RequestPart("file") MultipartFile file) {
		return videoService.save(videoDTO, file);
	}

	@GetMapping(value = "{moduleId}")
	public List<VideoDTO> getVideosByModuleId(@PathVariable Long moduleId) {
		return videoService.getVideosByModuleId(moduleId);
	}

	@GetMapping(value = "find-by-id/{videoId}")
	public ResponseEntity<InputStreamResource> findById(@PathVariable Long videoId) {
		return videoService.findById(videoId);
	}
}
