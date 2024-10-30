package com.tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.LectureDTO;
import com.tech.entity.Lecture;
import com.tech.mapper.LectureMapper;
import com.tech.repository.LectureRepository;

@Service // Spring will create an object of this class
public class LectureService {

    @Autowired // Spring will provide this object
    private LectureRepository lectureRepository;

    @Autowired
    private LectureMapper lectureMapper;

    public LectureDTO save(LectureDTO lectureDTO) {
        Lecture entity = lectureMapper.toEntity(lectureDTO);
        Lecture savedLecture = lectureRepository.save(entity); // Save entity to the database
        return lectureMapper.toDTO(savedLecture); // Convert and return the saved lecture as DTO
    }

    public List<LectureDTO> findAll() {
        List<Lecture> allLectures = lectureRepository.findAll();
        List<LectureDTO> lectureDTOs = new ArrayList<>();
        
        // Convert each Lecture entity to LectureDTO
        for (Lecture lecture : allLectures) {
            lectureDTOs.add(lectureMapper.toDTO(lecture));
        }
        
        return lectureDTOs; // Return the list of LectureDTOs
    }

    // Additional methods can be added here, such as findById, delete, etc.
}
