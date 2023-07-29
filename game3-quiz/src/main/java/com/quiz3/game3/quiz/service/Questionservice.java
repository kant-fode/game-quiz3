package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.QuestionRepository;
import com.quiz3.game3.quiz.modele.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Questionservice {
    @Autowired
    private QuestionRepository questionRepository;


    public Question creer(Question question) {

        return questionRepository.save(question);
    }

    public List<Question> lire() {

        return questionRepository.findAll();
    }

    public Question modifier(Long id, Question question) {
        return questionRepository.findById(id).map(q -> {
            q.setContenu(question.getContenu());
            q.setPoints(question.getPoints());
            return questionRepository.save(q);
        }).orElseThrow(() -> new RuntimeException("question introuvable ! "));
    }

    public String supprimer(Long id) {
        questionRepository.deleteById(id);
        return "Suppression effectuée !";
    }

    public Question findUtilisateurById(Long questionId) {

        return questionRepository.findQuestionById(questionId);
    }
}
