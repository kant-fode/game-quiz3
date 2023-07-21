package com.quiz3.game3.quiz.dao;

import com.quiz3.game3.quiz.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface Utilisateurdao_user extends JpaRepository<Utilisateur, Long> {
}
