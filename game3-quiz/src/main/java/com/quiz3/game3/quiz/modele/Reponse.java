package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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





}
