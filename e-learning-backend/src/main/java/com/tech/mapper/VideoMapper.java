package com.tech.mapper;

import org.springframework.stereotype.Component;

import com.tech.dto.VideoDTO;
import com.tech.entity.Video;

@Component
public class VideoMapper {
	public VideoDTO toDTO(Video video) {
		VideoDTO videoDTO = new VideoDTO();
		videoDTO.setId(video.getId());
		videoDTO.setName(video.getName());
		return videoDTO;
	}
	
	public Video toEntity(VideoDTO videoDTO) {
		Video video = new Video();
		video.setId(videoDTO.getId());
		video.setName(videoDTO.getName());
		return video;
	}
}
