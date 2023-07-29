package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);
}
