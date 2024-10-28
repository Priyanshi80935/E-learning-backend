package com.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.ModuleDTO;
import com.tech.dto.VideoDTO;
import com.tech.entity.ModuleEntity;
import com.tech.entity.Video;
import com.tech.mapper.VideoMapper;
import com.tech.repository.ModuleRepository;
import com.tech.repository.VideoRepository;

@Service
public class VideoService {
	@Autowired
	private VideoRepository videoRepository;
	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private ModuleRepository moduleRepository;

	public VideoDTO save(VideoDTO videoDTO) {
		ModuleDTO moduleDTO = videoDTO.getModuleDTO();
		Long moduleId = moduleDTO.getId();
		ModuleEntity moduleEntity = moduleRepository.findById(moduleId).get();
		
		Video entity = videoMapper.toEntity(videoDTO);
		Video save = videoRepository.save(entity);
		moduleEntity.getVideos().add(save);
		moduleRepository.save(moduleEntity);
		return videoMapper.toDTO(save);
	}
}
