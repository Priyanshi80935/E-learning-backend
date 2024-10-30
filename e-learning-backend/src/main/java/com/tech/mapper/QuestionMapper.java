package com.tech.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tech.dto.AnswerDTO;
import com.tech.dto.QuestionDTO;
import com.tech.entity.Answer;
import com.tech.entity.Question;

@Component
public class QuestionMapper {
    @Autowired
    private AnswerMapper answerMapper; // Mapper for Answer entities

    // Converts a Question entity to a QuestionDTO
    public QuestionDTO toDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setContent(question.getContent());

        // Convert List<Answer> to List<AnswerDTO>
        List<Answer> answers = question.getAnswers();
        List<AnswerDTO> answerDTOs = new ArrayList<>();
        if (answers != null) {
            for (Answer answer : answers) {
                answerDTOs.add(answerMapper.toDTO(answer));
            }
        }

        questionDTO.setAnswers(answerDTOs);
        return questionDTO;
    }

    // Converts a QuestionDTO to a Question entity
    public Question toEntity(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setContent(questionDTO.getContent());

        // Convert List<AnswerDTO> to List<Answer>
        List<AnswerDTO> answerDTOs = questionDTO.getAnswers();
        List<Answer> answers = new ArrayList<>();
        if (answerDTOs != null) {
            for (AnswerDTO answerDTO : answerDTOs) {
                answers.add(answerMapper.toEntity(answerDTO));
            }
        }

        question.setAnswers(answers);
        return question;
    }
}
