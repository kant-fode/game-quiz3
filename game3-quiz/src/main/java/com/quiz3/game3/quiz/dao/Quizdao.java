package com.quiz3.game3.quiz.dao;

import com.quiz3.game3.quiz.modele.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface Quizdao extends JpaRepository<Quiz, Long> {
}
