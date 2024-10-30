package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    private Long id;
    private String content; // The actual answer text
    private QuestionDTO questionDTO; // Reference to the Question to which this answer belongs
    private boolean correct; // Indicates if the answer is correct (useful for quizzes or assessments)
}
