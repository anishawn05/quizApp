package com.anish.quizapp.controller;

import com.anish.quizapp.model.Question;
import com.anish.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity< List<Question> > getAllQuestion(){
        return  questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public  ResponseEntity <List<Question> >getQuestionsBYCategory(@PathVariable String category)
    {
       return questionService.getQuestionsBYCategory(category);
    }
@PostMapping("/addNewQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question ){

     return questionService.addQuestion(question);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteQuestion(@PathVariable Integer id)
    {
        questionService.deleteQuestion(id);
    }
@PutMapping("/update/{id}")
    public Integer update(@RequestBody Question question,@PathVariable Integer id){
      questionService.update(question,id);
        return question.getId();


    }

}
