package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.Reponsedao;
import com.quiz3.game3.quiz.modele.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
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
            R.setEstCorrecte(rep.isEstCorrecte());
            R.setQuestion(rep.getQuestion());
            R.setUtilisateur(rep.getUtilisateur());
            return reponsedao.save(R);
        }).orElseThrow(() -> new RuntimeException("Reponse non trouvée avec l'identifiant : " + id));
    }

    public String supprimer(Long id) {
        reponsedao.deleteById(id);
        return "Suppression effectuée !";
    }
}


