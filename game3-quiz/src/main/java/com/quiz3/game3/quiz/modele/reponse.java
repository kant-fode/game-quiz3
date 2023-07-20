package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

@Entity
public class reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private boolean estCorrecte;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private question question;



}
