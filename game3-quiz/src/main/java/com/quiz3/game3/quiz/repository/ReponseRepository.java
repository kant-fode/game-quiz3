package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReponseRepository extends JpaRepository<Reponse, Long> {
   //  findReponsesByQuestion_Id( );

     List<Reponse> findReponsesByQuestion_Id(Long quizId);
}
