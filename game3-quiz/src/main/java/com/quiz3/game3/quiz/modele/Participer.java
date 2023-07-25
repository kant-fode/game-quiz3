package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Participer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Long id;
    private LocalDateTime localDateTime;
    @Column(nullable = false)
    private int score;
    //Association avec Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
    private Utilisateur utilisateur;
    //Association avc quiz
    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private Quiz quiz;

    public Participer() {

    }

    //getters et setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }





    // constructeur


    public Participer(Long id, LocalDateTime localDateTime, int score, Utilisateur utilisateur, Quiz quiz) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.score = score;
        this.utilisateur = utilisateur;
        this.quiz = quiz;
    }
}

