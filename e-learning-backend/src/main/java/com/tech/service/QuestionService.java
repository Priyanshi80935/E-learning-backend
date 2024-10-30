package com.tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.QuestionDTO;
import com.tech.entity.Question;
import com.tech.mapper.QuestionMapper;
import com.tech.repository.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionMapper questionMapper;

    public QuestionDTO save(QuestionDTO questionDTO) {
        Question question = questionMapper.toEntity(questionDTO);
        Question savedQuestion = questionRepository.save(question);
        return questionMapper.toDTO(savedQuestion);
    }

    public List<QuestionDTO> findAll() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (Question question : questions) {
            questionDTOs.add(questionMapper.toDTO(question));
        }
        return questionDTOs;
    }
}
