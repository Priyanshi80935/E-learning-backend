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
        lectureDTO.setDesignation(lecture.getDesignation());
        lectureDTO.setProfileImage(lecture.getProfileImage());
        lectureDTO.setInsta(lecture.getInsta());
        lectureDTO.setTwiter(lecture.getTwiter());
        lectureDTO.setFacebook(lecture.getFacebook());
        return lectureDTO;
    }

    public Lecture toEntity(LectureDTO lectureDTO) {
        if (lectureDTO == null) {
            return null; // Handle null case
        }

        Lecture lecture = new Lecture();
        lecture.setId(lectureDTO.getId());
        lecture.setName(lectureDTO.getName());
        lecture.setDesignation(lectureDTO.getDesignation());
        lecture.setProfileImage(lectureDTO.getProfileImage());
        lecture.setInsta(lectureDTO.getInsta());
        lecture.setTwiter(lectureDTO.getTwiter());
        lecture.setFacebook(lectureDTO.getFacebook());
        return lecture;
    }
}
