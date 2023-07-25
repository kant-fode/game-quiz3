package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.QuestionRepository;
import com.quiz3.game3.quiz.modele.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Questionservice {
    @Autowired
    private QuestionRepository questiondao;

    public Question creer(Question question) {
        return questiondao.save(question);
    }

    public List<Question> lire() {
        return questiondao.findAll();
    }

    public Question modifier(Long id, Question question) {
        return questiondao.findById(id).map(q -> {
            q.setOption1(question.getOption1());
            q.setOption2(question.getOption2());
            q.setOption3(question.getOption3());
            q.setOption4(question.getOption4());
            q.setContent(question.getContent());
            q.setQuiz(question.getQuiz());
            q.setReponses(question.getReponses());
            return questiondao.save(q);
        }).orElseThrow(() -> new RuntimeException("question introuvable : " + id));
    }

    public String supprimer(Long id) {
        questiondao.deleteById(id);
        return "Suppression effectuée !";
    }
}
