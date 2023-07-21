package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(length = 50)
    private String pseudo;
    @Column(length = 50)
    private String email;
    @Column(length = 50)

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Association avec Quiz
    @OneToMany(mappedBy = "utilisateur")
    private List<Quiz> quizCrees;

    // Association avec Quiz (pour les quiz auxquels l'utilisateur a participé)
   /* @ManyToMany(mappedBy = "utilisateur")
    private List<quiz> quizParticipes;

    // Association avec Réponse
    @OneToMany(mappedBy = "utilisateur")
    private List<reponse> reponses;*/

}

