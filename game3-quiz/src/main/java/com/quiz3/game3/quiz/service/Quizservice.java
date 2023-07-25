package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.Quizrepository;
import com.quiz3.game3.quiz.modele.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Quizservice {
    @Autowired
    private Quizrepository quizdao;

    public Quiz creer(Quiz quiz) {
        return quizdao.save(quiz);
    }

    public List<Quiz> lire() {
        return quizdao.findAll();
    }

    public List<Quiz> chercherQuiz(String titre) {
        return quizdao.findByTritreContaining(titre);
    }

    public Quiz modifier(Long id, Quiz quiz) {
        return quizdao.findById(id).map(q -> {
            q.setCategorie(quiz.getCategorie());
            q.setTritre(quiz.getTritre());
            return quizdao.save(q);
        }).orElseThrow(() -> new RuntimeException("quiz introuvable : " + id));
    }

    public String supprimer(Long id) {
        quizdao.deleteById(id);
        return "Suppression effectuée !";
    }

    public Optional<Quiz> getQuizById(Long quizId) {
        return null;
    }
}

