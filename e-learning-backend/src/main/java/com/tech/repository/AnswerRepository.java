package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.Answer; 

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    
}
