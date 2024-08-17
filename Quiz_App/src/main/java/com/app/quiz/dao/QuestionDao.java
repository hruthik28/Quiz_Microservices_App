package com.app.quiz.dao;

import com.app.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao  extends JpaRepository<Question, Integer> {

}
