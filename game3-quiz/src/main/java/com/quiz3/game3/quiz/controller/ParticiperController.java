package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.modele.Participer;
import com.quiz3.game3.quiz.modele.Quiz;
import com.quiz3.game3.quiz.modele.Utilisateur;
import com.quiz3.game3.quiz.service.Participerservice;
import com.quiz3.game3.quiz.service.Quizservice;
import com.quiz3.game3.quiz.service.Utilisateurservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/participation")
public class ParticiperController {

        private final Participerservice participerService;
        private final Utilisateurservice utilisateurService;
        private final Quizservice quizService;

        @Autowired
        public ParticiperController(Participerservice participerService, Utilisateurservice utilisateurService, Quizservice quizService) {
            this.participerService = participerService;
            this.utilisateurService = utilisateurService;
            this.quizService = quizService;
        }

        @PostMapping("/{utilisateurId}/{quizId}")
        public ResponseEntity<Participer> participerQuiz(
                @PathVariable Long utilisateurId,
                @PathVariable Long quizId
        ) {
            // Récupérer l'utilisateur à partir de l'ID utilisateur
            Optional<Utilisateur> optionalUtilisateur = utilisateurService.getUtilisateurById(utilisateurId);
            if (!optionalUtilisateur.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Utilisateur utilisateur = optionalUtilisateur.get();

            // Récupérer le quiz à partir de l'ID quiz
            Optional<Quiz> optionalQuiz = quizService.getQuizById(quizId);
            if (!optionalQuiz.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Quiz quiz = optionalQuiz.get();

            // Enregistrer la participation de l'utilisateur au quiz
            Participer participer = participerService.participerQuiz(utilisateur, quiz);

            return ResponseEntity.ok(participer);
        }


    }



