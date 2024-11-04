package com.tech.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.dto.ModuleDTO;
import com.tech.dto.VideoDTO;
import com.tech.entity.ModuleEntity;
import com.tech.entity.Video;
import com.tech.mapper.VideoMapper;
import com.tech.repository.ModuleRepository;
import com.tech.repository.VideoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class VideoService {
    private static final String VIDEO_DIRECTORY = "D://e-learning/videos";
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private ModuleRepository moduleRepository;

    public VideoDTO save(VideoDTO videoDTO, MultipartFile file) {
        File directory = new File(VIDEO_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Generate a file path with the original filename
        String originalFilename = file.getOriginalFilename();

        String filePath = VIDEO_DIRECTORY + File.separator + originalFilename;
        Path path = Paths.get(filePath);
        try {
            Files.write(path, file.getBytes());
            videoDTO.setOriginalFileName(originalFilename);
            log.info("File saved to: {}", filePath);
        } catch (IOException e) {
            log.error("Error saving file: {}", e.getMessage());
        }

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

    public ResponseEntity<InputStreamResource> findById(Long videoId) {
            Video video = videoRepository.findById(videoId).get();
        String filePath = VIDEO_DIRECTORY + File.separator + video.getOriginalFileName();

            File file = new File(filePath);
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            try {
                InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

                // Prepare response headers
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + video.getOriginalFileName());
                headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(file.toPath()));

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(resource);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
    }
}
