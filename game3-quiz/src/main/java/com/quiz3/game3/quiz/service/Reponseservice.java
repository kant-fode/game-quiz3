package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.Reponsedao;
import com.quiz3.game3.quiz.modele.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class Reponseservice {
    @Autowired

    private Reponsedao reponsedao;

    public Reponse creer(Reponse rep) {
        return reponsedao.save(rep);
    }

    public List<Reponse> lire() {
        return reponsedao.findAll();
    }

    public Reponse modifier(Long id, Reponse rep) {
        return reponsedao.findById(id).map(R -> {
            R.setContenu(rep.getContenu());
            R.setReponseType(rep.isReponseType());
            R.setQuestion(rep.getQuestion());
            return reponsedao.save(R);
        }).orElseThrow(() -> new RuntimeException("Reponse non trouvée avec l'identifiant : " + id));
    }

    public String supprimer(Long id) {
        reponsedao.deleteById(id);
        return "Suppression effectuée !";
    }

        public Optional<Reponse> getResponseById(Long checkedReponseID) {
        return reponsedao.findById(checkedReponseID);
    }

    public List<Reponse> getAllResponseByQuestionId(Long quizId) {
        return reponsedao.findReponsesByQuestion_Id(quizId);
    }
}


