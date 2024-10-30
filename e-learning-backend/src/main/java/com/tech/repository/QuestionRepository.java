package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.Question; // Change this to the actual Question entity import

public interface QuestionRepository extends JpaRepository<Question, Long> {
    
}
