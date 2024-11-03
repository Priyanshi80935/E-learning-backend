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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private ModuleRepository moduleRepository;

    public VideoDTO save(VideoDTO videoDTO) {
        Long moduleId = videoDTO.getModuleId();
        ModuleEntity moduleEntity = moduleRepository.findById(moduleId).get();

        Video entity = videoMapper.toEntity(videoDTO);
        Video save = videoRepository.save(entity);
        moduleEntity.getVideos().add(save);
        moduleRepository.save(moduleEntity);
        return videoMapper.toDTO(save);
    }

    public List<VideoDTO> getVideosByModuleId(Long moduleId) {
        List<Video> videos = moduleRepository.findById(moduleId).get().getVideos();
        List<VideoDTO> videoDTOS = new ArrayList<>();
        for (Video video : videos) {
            videoDTOS.add(videoMapper.toDTO(video));
        }
        return videoDTOS;
    }

    @Transactional
    public VideoDTO findById(Long videoId) {
        Video video = videoRepository.findById(videoId).get();
        VideoDTO dto = videoMapper.toDTO(video);
        dto.setContent(video.getContent());
        return dto;
    }
}
