package com.quiz3.game3.quiz.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private long id;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "integer default 1")
    private int points;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    //relation
    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    // Relation OneToMany avec les réponses de la question
    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Reponse> reponses;

    public Question(long id, String content, int points, Quiz quiz, List<Reponse> reponses) {
        this.id = id;
        this.content = content;
        this.points = points;
        this.quiz = quiz;
        this.reponses = reponses;
    }

    public Question() {
    }


    public Quiz getQuiz() {
        return quiz;
    }


    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

