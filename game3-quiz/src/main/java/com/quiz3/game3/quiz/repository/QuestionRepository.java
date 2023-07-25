package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Long> {
}
