package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.ApiResponse;
import com.quiz3.game3.quiz.modele.*;
import com.quiz3.game3.quiz.service.ParticiperService;
import com.quiz3.game3.quiz.service.Questionservice;
import com.quiz3.game3.quiz.service.Reponseservice;
import com.quiz3.game3.quiz.service.Utilisateurservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("participer")
@RestController
public class ParticiperController {

    private final ParticiperService participerService;
    private final Utilisateurservice utilisateurservice;
    private final Questionservice questionservice;
    private final Reponseservice reponseservice;
@Autowired
    public ParticiperController(ParticiperService participerService, Utilisateurservice utilisateurservice, Questionservice questionservice, Reponseservice reponseservice) {
        this.participerService = participerService;
        this.utilisateurservice = utilisateurservice;
        this.questionservice = questionservice;
        this.reponseservice = reponseservice;
    }

    // initialisation de la participation
    @GetMapping("/{userId}/{quizId}/commencement")
    public String commencement(@PathVariable Long userId,@PathVariable Long quizId, @RequestParam Long checkedReponseID){

        Participer participer = participerService.getParticiperByUserAndQuestionId(userId, quizId);
        if (participer != null){
            participerService.modifierParticiper(participer.getId(),0);
        }
        return "Le jeu commence...";
    }
 @GetMapping("/{userId}/{quizId}/{questionId}")
    public ApiResponse jouer (@PathVariable Long userId,@PathVariable Long quizId, @PathVariable Long questionId, @RequestParam Long checkedReponseID){
     Utilisateur utilisateur = utilisateurservice.findUtilisateurById(userId);
     Question question = questionservice.findUtilisateurById(questionId);
     Quiz quiz = question.getQuiz();

     Long quizzId = quiz.getId();
     boolean checkResponse = reponseservice.getResponseById(checkedReponseID).get().isReponseType();
     Participer participer = participerService.getParticiperByUserAndQuestionId(userId, quizzId);
     if (participer == null){
         participer = new Participer();
         participer.setScore(0);
         participer.setQuiz(quiz);
         participer.setUtilisateur(utilisateur);
         participerService.creerparticipation(participer);
     }
     List<Reponse> responses = reponseservice.getAllResponseByQuestionId(questionId);
     if (checkResponse){
         participerService.modifierParticiper(participer.getId(),participer.getScore()+question.getPoints());
         return new ApiResponse(200, utilisateur.getPseudo()+ " vous avez choisi la bonne reponse votre score est de  " +(participer.getScore()+question.getPoints()),"win");
     }else
         return new ApiResponse(200,utilisateur.getPseudo()+" vous avez choisi la Mauvaise reponse "+checkedReponseID, "Game over");
 }



}
