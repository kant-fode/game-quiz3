package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {
   //  findReponsesByQuestion_Id( );

     List<Reponse> findReponsesByQuestion_Id(Long quizId);
}
