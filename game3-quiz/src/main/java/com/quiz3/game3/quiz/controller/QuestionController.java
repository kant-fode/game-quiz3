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

    @PostMapping("/creer")
    public Question creer(@RequestBody Question question){
        return questionservice.creer(question);
    }
    @GetMapping("")
    public List<Question> list(){
        return questionservice.lire();
    }
    @PutMapping("/modifier/{id}")
    public Question modifier(@PathVariable Long id, @RequestBody Question question){
        return questionservice.modifier(id,question);
    }
    @DeleteMapping("/supprimer")
    public String supprimer (@PathVariable Long id){
        return questionservice.supprimer(id);
    }
}
