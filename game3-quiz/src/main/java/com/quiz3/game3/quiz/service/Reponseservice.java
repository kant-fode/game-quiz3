package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.ReponseRepository;
import com.quiz3.game3.quiz.modele.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class Reponseservice {
    @Autowired

    private ReponseRepository reponseRepository;
    private Reponse reponse;

    public Reponse creer(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    public List<Reponse> lire() {
        return reponseRepository.findAll();
    }

    public Reponse modifier(Long id, Reponse reponse) {
        this.reponse = reponse;
        return reponseRepository.findById(id).map(R -> {
            R.setContenu(R.getContenu());
            R.setReponseType(R.isReponseType());
            return reponseRepository.save(R);
        }).orElseThrow(() -> new RuntimeException("Reponse non trouvée ! " ));
    }

    public String supprimer(Long id) {
        reponseRepository.deleteById(id);
        return "Suppression effectuée !";
    }

        public Optional<Reponse> getResponseById(Long checkedReponseID) {
        return reponseRepository.findById(checkedReponseID);
    }

    public List<Reponse> getAllResponseByQuestionId(Long quizId) {
        return reponseRepository.findReponsesByQuestion_Id(quizId);
    }
}


