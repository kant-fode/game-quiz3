package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.modele.utilisateur;

import java.util.List;

public interface utilisateurservice {

    utilisateur creer(utilisateur quiz);
    List<utilisateur> lire();
    utilisateur modifier(Long id, utilisateur quiz);
    String supprimer(Long id);
}
