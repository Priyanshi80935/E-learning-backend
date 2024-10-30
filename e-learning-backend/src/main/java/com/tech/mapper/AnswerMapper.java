package com.tech.mapper;

import org.springframework.stereotype.Component;

import com.tech.dto.AnswerDTO;
import com.tech.entity.Answer;

@Component
public class AnswerMapper {
    // Converts an Answer entity to an AnswerDTO
    public AnswerDTO toDTO(Answer answer) {
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(answer.getId());
        answerDTO.setContent(answer.getContent());
        answerDTO.setCorrect(answer.getCorrect());
        return answerDTO;
    }

    // Converts an AnswerDTO to an Answer entity
    public Answer toEntity(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setId(answerDTO.getId());
        answer.setContent(answerDTO.getContent());
        answer.setCorrect(answerDTO.getCorrect());
        return answer;
    }
}
