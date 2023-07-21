package com.quiz3.game3.quiz.dao;

import com.quiz3.game3.quiz.modele.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface Questiondao extends JpaRepository<Question, Long> {
}
