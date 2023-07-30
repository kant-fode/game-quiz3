package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List <Quiz> findByTitre(String titre);
}
