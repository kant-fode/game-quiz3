package com.quiz3.game3.quiz.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private long id;
    @Column(length = 20)
    private String pseudo;
    @Column(length = 20)
    private String email;
    @Column(length = 20)
    private String password;

    // Association avec Quiz
    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL)
    private List<Quiz> quizCrees = new ArrayList<>();
    //getter & setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Quiz> getQuizCrees() {
        return quizCrees;
    }

    public void setQuizCrees(List<Quiz> quizCrees) {
        this.quizCrees = quizCrees;
    }


//construteur
    public Utilisateur() {


    }

    public Utilisateur(long id, String pseudo, String email, List<Quiz> quizCrees) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.quizCrees = quizCrees;


    }



    // Association avec Quiz (pour les quiz auxquels l'utilisateur a participé)

    /*@ManyToMany(mappedBy = "utilisateur")
    private List<quiz> quizParticipes;

    // Association avec Réponse
    @OneToMany(mappedBy = "utilisateur")
    private List<reponse> reponses;*/
}

