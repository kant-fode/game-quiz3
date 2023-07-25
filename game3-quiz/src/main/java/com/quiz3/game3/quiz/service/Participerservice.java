/*package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.modele.Participer;
import com.quiz3.game3.quiz.modele.Quiz;
import com.quiz3.game3.quiz.modele.Utilisateur;
import com.quiz3.game3.quiz.repository.ParticiperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Participerservice {
    private final ParticiperRepository participerRepository = null;
    @Autowired
    public Participerservice(ParticiperRepository participerRepository) {
        this.participerRepository = participerRepository;
    }
    //Methode pour modifier la participation d'un utilisateur à un quiz avc un score
    public Participer modifier(Utilisateur utilisateur, Quiz quiz, int score){
       Participer participerId = new Participer();
       participerId.setUtilisateur(utilisateur);
       participerId.setQuiz(quiz);
        return participerId;
    }

    private Long participerId;
    // Vérifier si la participation existe déjà dans la base de données
    Optional<Participer> optionalParticipation = participerRepository.findById(participerId);
    Participer participer;

    if(optionalParticipation.isPresent()){
        participer = optionalParticipation.get();
        participer.setScore(participer.getScore());

    }else{
        // Si la participation n'existe pas, la créer avec le score
        participer = new Participer();
        participer.setId(participerId);
        participer.setLocalDateTime(LocalDateTime.now());
        participer.setScore(participer.getScore());
    }



    
}*/
