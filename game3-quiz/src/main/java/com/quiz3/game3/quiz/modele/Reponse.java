package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Long id;
    @Column(nullable = false)
    private String contenu;
    @Column(nullable = false)
    private boolean reponseType;

    // Association avec Question
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Reponse() {

    }
    //getter et setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public boolean isReponseType() {
        return reponseType;
    }

    public void setReponseType(boolean reponseType) {
        this.reponseType = reponseType;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
//constructeur

    public Reponse(Long id, String contenu, boolean reponseType, Question question) {
        this.id = id;
        this.contenu = contenu;
        this.reponseType = reponseType;
        this.question = question;
    }
}
