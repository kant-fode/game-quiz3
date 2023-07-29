package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.ApiResponse;
import com.quiz3.game3.quiz.modele.Utilisateur;
import com.quiz3.game3.quiz.service.Utilisateurservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("utilisateur")

public class UtilisateurController {
    private final Utilisateurservice utilisateurservice;

    public UtilisateurController(Utilisateurservice utilisateurservice) {
        this.utilisateurservice = utilisateurservice;
    }

    @PostMapping("/inscrire")
    public Utilisateur inscrire(@RequestBody Utilisateur utilisateur){
        return utilisateurservice.inscrire(utilisateur);
    }
    @GetMapping("")
    public Optional<List> read(){
       Optional<List> user = Optional.ofNullable(utilisateurservice.lire());
       return Optional.ofNullable(user.orElse(null));
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id){
        return utilisateurservice.getUtilisateurById(id);
    }
    @PutMapping("/update/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurservice.modifier(id,utilisateur);
    }
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        return utilisateurservice.supprimer(id);
    }


    @PostMapping("/login")
    public ApiResponse login(@RequestParam  String email, String password){
        return  utilisateurservice.login(email, password);
    }


}