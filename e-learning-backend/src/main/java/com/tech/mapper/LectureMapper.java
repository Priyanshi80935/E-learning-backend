package com.tech.mapper;

import org.springframework.stereotype.Component;

import com.tech.dto.LectureDTO;
import com.tech.entity.Lecture;

@Component // Spring will create an object of this class
public class LectureMapper {

    public LectureDTO toDTO(Lecture lecture) {
        if (lecture == null) {
            return null; // Handle null case
        }

        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.setId(lecture.getId());
        lectureDTO.setName(lecture.getName());

        return lectureDTO;
    }

    public Lecture toEntity(LectureDTO lectureDTO) {
        if (lectureDTO == null) {
            return null; // Handle null case
        }

        Lecture lecture = new Lecture();
        lecture.setId(lectureDTO.getId());
        lecture.setName(lectureDTO.getName());

        return lecture;
    }
}
