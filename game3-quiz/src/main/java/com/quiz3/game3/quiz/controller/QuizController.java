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

    @PostMapping("/creer")
    public Quiz creer(@RequestBody Quiz quiz){
        return quizservice.creer(quiz);
    }
    @GetMapping("")
    public List<Quiz> list(){
        return quizservice.lire();
    }

    @GetMapping("/rechercher/{titre}")
    public List<Quiz> rechercher(@PathVariable String titre){
        return quizservice.chercherQuiz(titre);
    }
    @PutMapping("/modifier/{id}")
    public Quiz modifier(@PathVariable Long id, @RequestBody Quiz quiz){
        return quizservice.modifier(id,quiz);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return quizservice.supprimer(id);
    }
}
