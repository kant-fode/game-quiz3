package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.modele.Reponse;
import com.quiz3.game3.quiz.service.Reponseservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("reponse")
public class ReponseController {
    private final Reponseservice reponseservice;

    public ReponseController(Reponseservice reponseservice) {
        this.reponseservice = reponseservice;
    }

    @PostMapping("/creer")
    public Reponse creer(@RequestBody Reponse reponse){
        return reponseservice.creer(reponse);
    }
    @GetMapping("")
    public List<Reponse> list(){
        return reponseservice.lire();
    }
    @PutMapping("/modifier/{id}")
    public Reponse modifier(@PathVariable Long id, @RequestBody Reponse reponse){
        return reponseservice.modifier(id,reponse);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id){
        return reponseservice.supprimer(id);
    }

}
