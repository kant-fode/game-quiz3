package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.modele.Participer;
import com.quiz3.game3.quiz.repository.ParticiperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ParticiperService {
    @Autowired
    private ParticiperRepository participerRepository;
    public Participer creerparticipation(Participer participer){

        return participerRepository.save(participer);
    }
    public List<Participer> list(){

        return participerRepository.findAll();
    }

    public Optional<Participer> list(Long id){

        return participerRepository.findById(id);
    }

    public Participer modifierParticiper(Long id, int score){
      return participerRepository.findById(id)
              .map(p ->{
                  p.setScore(p.getScore());
                  p.setLocalDateTime(p.getLocalDateTime().MAX);
                  return participerRepository.save(p);
              }).orElseThrow(() -> new RuntimeException("non trouvé"));

    }
    public String supprimer(Long id){
        participerRepository.deleteById(id);
        return "Supprimer";
    }



    public Participer getParticiperByUserAndQuestionId(Long userId, Long quizId) {
        return participerRepository.findByUtilisateur_IdAndQuiz_Id(userId,quizId);
    }
}


