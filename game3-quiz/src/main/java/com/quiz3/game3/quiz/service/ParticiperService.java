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
    public Participer createQuestion(Participer participer){

        return participerRepository.save(participer);
    }
    public List<Participer> getAllQuestion(){

        return participerRepository.findAll();}

    public Optional<Participer> getParticiperById(Long id){

        return participerRepository.findById(id);}

    public String editParticiper(Long id, int score){
      participerRepository.findById(id)
              .map(p ->{
                  p.setScore(score);
                  //p.setLocalDateTime(LocalDateTime.MAX);
                  return participerRepository.save(p);
              }).orElseThrow(() -> new RuntimeException("non trouvé"));
                return "mopdification reussie";
    }
    public boolean deleQuestionById(Long id){
        participerRepository.deleteById(id);
        return true;
    }

    public Participer getParticiperByUserAndQuizId(Long userId, Long quizId){
        return participerRepository.findByUtilisateur_IdAndQuiz_Id(userId,quizId);
    }


    public Participer getParticiperByUserAndQuestionId(long userId, Long quizId) {
        return participerRepository.findByUtilisateur_IdAndQuiz_Id(userId,quizId);
    }
}


