package com.tech.mapper;

import org.springframework.stereotype.Component;

import com.tech.dto.VideoDTO;
import com.tech.entity.Video;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class VideoMapper {
	public VideoDTO toDTO(Video video) {
		VideoDTO videoDTO = new VideoDTO();
		videoDTO.setId(video.getId());
		videoDTO.setName(video.getName());
		videoDTO.setDescription(video.getDescription());
		videoDTO.setVideoNumber(video.getVideoNumber());
		videoDTO.setOriginalFileName(video.getOriginalFileName());
		return videoDTO;
	}
	
	public Video toEntity(VideoDTO videoDTO) {
		Video video = new Video();
		video.setId(videoDTO.getId());
		video.setName(videoDTO.getName());
		video.setDescription(videoDTO.getDescription());
		video.setVideoNumber(videoDTO.getVideoNumber());
		video.setOriginalFileName(videoDTO.getOriginalFileName());
		return video;
	}
}
