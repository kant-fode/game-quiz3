package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.modele.Question;
import com.quiz3.game3.quiz.service.Questionservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("question")
public class QuestionController {

    private final Questionservice questionservice;

    public QuestionController(Questionservice questionservice){
        this.questionservice = questionservice;
    }

    @PostMapping("/create")
    public Question create(@RequestBody Question question){
        return questionservice.creer(question);
    }
    @GetMapping("")
    public List<Question> read(){
        return questionservice.lire();
    }
    @PutMapping("/update/{id}")
    public Question update(@PathVariable Long id, @RequestBody Question question){
        return questionservice.modifier(id,question);
    }
    @DeleteMapping("/delete")
    public String delete (@PathVariable Long id){
        return questionservice.supprimer(id);
    }
}
