package com.quiz3.game3.quiz.dao;

import com.quiz3.game3.quiz.modele.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface utilisateurdao_user extends JpaRepository<utilisateur, Long> {
}
