package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Participer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticiperRepository extends JpaRepository<Participer, Long> {

    Participer findByUtilisateur_IdAndQuiz_Id(Long userId, Long quizId);
}
