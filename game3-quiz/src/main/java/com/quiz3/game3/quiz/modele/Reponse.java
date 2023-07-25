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
    private boolean estCorrecte;

    // Association avec Question
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // Association avec Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

//getter et setter
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public boolean isEstCorrecte() {
        return estCorrecte;
    }

    public void setEstCorrecte(boolean estCorrecte) {
        this.estCorrecte = estCorrecte;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
