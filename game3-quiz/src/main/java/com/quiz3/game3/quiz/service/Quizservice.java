package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.QuizRepository;
import com.quiz3.game3.quiz.modele.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Quizservice {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz creer(Quiz quiz) {

        return quizRepository.save(quiz);
    }

    public List<Quiz> lire() {

        return quizRepository.findAll();
    }

    public List<Quiz> chercherQuiz(String titre) {

        return quizRepository.findByTitre(titre);
    }

    public Quiz modifier(Long id, Quiz quiz) {
        return quizRepository.findById(id).map(q -> {
            q.setTitre(quiz.getTitre());
            return quizRepository.save(q);
        }).orElseThrow(() -> new RuntimeException("quiz introuvable !"));
    }

    public String supprimer(Long id) {
        quizRepository.deleteById(id);
        return "Suppression effectuée !";
    }

    public Optional<Quiz> getQuizById(Long quizId) {
        return null;
    }
}

