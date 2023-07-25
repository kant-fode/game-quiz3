package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.modele.Quiz;
import com.quiz3.game3.quiz.service.Quizservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final Quizservice quizservice;

    public QuizController(Quizservice quizservice) {
        this.quizservice = quizservice;
    }

    @PostMapping("/create")
    public Quiz create(@RequestBody Quiz quiz){
        return quizservice.creer(quiz);
    }
    @GetMapping("")
    public List<Quiz> read(){
        return quizservice.lire();
    }

    @GetMapping("/chercher/{titre}")
    public List<Quiz> chercher(@PathVariable String titre){
        return quizservice.chercherQuiz(titre);
    }
    @PutMapping("/update/{id}")
    public Quiz update(@PathVariable Long id, @RequestBody Quiz quiz){
        return quizservice.modifier(id,quiz);
    }
    @DeleteMapping("/delete")
    public String delete (@PathVariable Long id){
        return quizservice.supprimer(id);
    }
}
