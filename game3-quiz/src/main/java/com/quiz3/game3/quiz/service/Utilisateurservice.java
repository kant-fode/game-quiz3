package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.modele.Utilisateur;

import java.util.List;

public interface Utilisateurservice {

    Utilisateur creer(Utilisateur quiz);

    List<Utilisateur> lire();

    Utilisateur modifier(Long id, Utilisateur quiz);

    String supprimer(Long id);
}
