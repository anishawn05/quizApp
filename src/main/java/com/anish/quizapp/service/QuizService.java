package com.anish.quizapp.service;

import com.anish.quizapp.dao.QuestionDao;

import com.anish.quizapp.dao.QuizDao;
import com.anish.quizapp.model.Question;
import com.anish.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizdao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);;
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);
        return  new ResponseEntity<>("sucess", HttpStatus.CREATED);


    }
}
