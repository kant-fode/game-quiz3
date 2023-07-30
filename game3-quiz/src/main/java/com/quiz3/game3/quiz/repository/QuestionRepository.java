package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findQuestionById(Long questionId);
}
