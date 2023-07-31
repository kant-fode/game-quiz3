package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.ApiResponse;
import com.quiz3.game3.quiz.modele.Utilisateur;
import com.quiz3.game3.quiz.service.Utilisateurservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")

public class UtilisateurController {
    private final Utilisateurservice utilisateurservice;

    //constructeur
    public UtilisateurController(Utilisateurservice utilisateurservice) {
        this.utilisateurservice = utilisateurservice;
    }

    @PostMapping("/inscrire")
    public Utilisateur inscrire(@RequestBody Utilisateur utilisateur){
        return utilisateurservice.inscrire(utilisateur);
    }
    /*@GetMapping("")
    public Optional<List> read(){
       Optional<List> user = Optional.ofNullable(utilisateurservice.lire());
       return Optional.ofNullable(user.orElse(null));
    }*/
    @GetMapping("")
    public List<Utilisateur> list(){
        return utilisateurservice.lire();
    }

    @GetMapping("/{id}")
    public Utilisateur rechercher(@PathVariable Long id){
        return utilisateurservice.getUtilisateurById(id);
    }
    @PutMapping("/modifier/{id}")
    public Utilisateur modifier(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurservice.modifier(id,utilisateur);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return utilisateurservice.supprimer(id);
    }


    @PostMapping("/connecter")
    public ApiResponse connecter(@RequestParam  String email,@RequestParam String password){
        return  utilisateurservice.connecter(email, password);
    }


}