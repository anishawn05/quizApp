package com.anish.quizapp.service;

import com.anish.quizapp.model.Question;
import com.anish.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
@Autowired

QuestionDao questionDao;




    public ResponseEntity< List<Question> >getAllQuestions() {
        try {
            return new ResponseEntity<>( questionDao.findAll(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsBYCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionDao.save(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("NOt accept",HttpStatus.CREATED);
    }
    public  void deleteQuestion(Integer id) {
         questionDao.deleteById(id);

    }
    public void update(Question question, Integer id) {
       questionDao.save(question);

    }
}
