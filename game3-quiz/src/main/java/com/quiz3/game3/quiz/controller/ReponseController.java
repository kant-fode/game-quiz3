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

    @PostMapping("/create")
    public Reponse create(@RequestBody Reponse reponse){
        return reponseservice.creer(reponse);
    }
    @GetMapping("")
    public List<Reponse> read(){
        return reponseservice.lire();
    }
    @PutMapping("/update/{id}")
    public Reponse update(@PathVariable Long id, @RequestBody Reponse reponse){
        return reponseservice.modifier(id,reponse);
    }
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        return reponseservice.supprimer(id);
    }

}
