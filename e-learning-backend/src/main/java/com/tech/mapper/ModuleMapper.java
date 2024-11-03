package com.tech.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tech.dto.ModuleDTO;
import com.tech.dto.VideoDTO;
import com.tech.entity.ModuleEntity;
import com.tech.entity.Video;

@Component
public class ModuleMapper {
	@Autowired
	private VideoMapper videoMapper;
	
	public ModuleDTO toDTO(ModuleEntity module) {
		ModuleDTO moduleDTO = new ModuleDTO();
		moduleDTO.setId(module.getId());
		moduleDTO.setName(module.getName());
		moduleDTO.setModuleNumber(module.getModuleNumber());
		moduleDTO.setDescription(module.getDescription());
		
		List<Video> videos = module.getVideos();
		List<VideoDTO> videoDTOs = new ArrayList<>();
		if(videos != null) {
			for(Video video : videos) {
				videoDTOs.add(videoMapper.toDTO(video));
			}
		}
		
		moduleDTO.setVideos(videoDTOs);
		return moduleDTO;
	}
	
	public ModuleEntity toEntity(ModuleDTO moduleDTO) {
		ModuleEntity moduleEntity = new ModuleEntity();
		moduleEntity.setId(moduleDTO.getId());
		moduleEntity.setName(moduleDTO.getName());
		moduleEntity.setDescription(moduleDTO.getDescription());
		moduleEntity.setModuleNumber(moduleDTO.getModuleNumber());
		List<VideoDTO> videoDTOs = moduleDTO.getVideos();
		List<Video> videos = new ArrayList<>(); 
		if(videoDTOs != null) {
			for(VideoDTO videoDTO : videoDTOs) {
				videos.add(videoMapper.toEntity(videoDTO));
			}
		}
		moduleEntity.setVideos(videos);
		return moduleEntity;
		
	}
}
