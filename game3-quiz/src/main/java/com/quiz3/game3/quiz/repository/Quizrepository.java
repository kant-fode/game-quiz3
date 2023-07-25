package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Quizrepository extends JpaRepository<Quiz, Long> {
    List <Quiz> findByTritreContaining(String titre);
}
