package com.quizApp.quiz_service.controller;

import com.quizApp.quiz_service.model.QuestionWrapper;
import com.quizApp.quiz_service.model.QuizDto;
import com.quizApp.quiz_service.model.Response;
import com.quizApp.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategory(), quizDto.getNoOfQuestions(), quizDto.getTitle());
    }

    @GetMapping("get/{id}") //QuestionWrapper is used to return only question and options and not answer,
    // if Question model is used it will return all so this wrapper class will prevent the issue
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responseList){
        return quizService.calculateResult(id, responseList);
    }
}
