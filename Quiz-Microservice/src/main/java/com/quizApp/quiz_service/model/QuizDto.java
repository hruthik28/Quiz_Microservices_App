package com.quizApp.quiz_service.model;

import lombok.Data;

@Data
public class QuizDto {
    String category;
    Integer noOfQuestions;
    String title;
}
