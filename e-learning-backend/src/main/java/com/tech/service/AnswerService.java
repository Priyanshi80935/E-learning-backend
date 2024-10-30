package com.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.AnswerDTO;
import com.tech.dto.QuestionDTO;
import com.tech.entity.Answer;
import com.tech.entity.Question;
import com.tech.mapper.AnswerMapper;
import com.tech.repository.AnswerRepository;
import com.tech.repository.QuestionRepository;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private QuestionRepository questionRepository;

    public AnswerDTO save(AnswerDTO answerDTO) {
        QuestionDTO questionDTO = answerDTO.getQuestionDTO();
        Long questionId = questionDTO.getId();
        Question questionEntity = questionRepository.findById(questionId).orElseThrow(() -> 
            new RuntimeException("Question not found with id: " + questionId));

        // Convert the AnswerDTO to an Answer entity
        Answer entity = answerMapper.toEntity(answerDTO);
        
        // Set the question for the answer
        entity.setQuestion(questionEntity);

        // Save the answer entity
        Answer savedAnswer = answerRepository.save(entity);

        // Optionally, you can add the saved answer to the question's answers list
        questionEntity.getAnswers().add(savedAnswer);
        questionRepository.save(questionEntity); // Update the question entity with the new answer

        // Convert the saved answer entity back to DTO and return it
        return answerMapper.toDTO(savedAnswer);
    }


    
}
