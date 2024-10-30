package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tech.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    // Additional custom query methods can be defined here if needed
}
