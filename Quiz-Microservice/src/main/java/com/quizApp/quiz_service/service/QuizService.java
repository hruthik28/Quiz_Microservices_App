package com.quizApp.quiz_service.service;

import com.quizApp.quiz_service.dao.QuizDao;
import com.quizApp.quiz_service.feign.QuizInterface;
import com.quizApp.quiz_service.model.Question;
import com.quizApp.quiz_service.model.QuestionWrapper;
import com.quizApp.quiz_service.model.Quiz;
import com.quizApp.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
        List<Integer> questionIds = quizInterface.getQuestionsForQuiz(category, noOfQuestions).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIds);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responseList) {
        ResponseEntity<Integer> score = quizInterface.getScore(responseList);
        return score;
    }
}
