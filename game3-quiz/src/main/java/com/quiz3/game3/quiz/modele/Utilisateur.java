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
    @OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizCreer = new ArrayList<>();

   @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participer> participers = new ArrayList<>();



    /*@ManyToMany(mappedBy = "utilisateurs", cascade = CascadeType.ALL)
    private Set<Quiz> quizs = new HashSet<>();*/
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

    public List<Quiz> getQuizCreer() {
        return quizCreer;
    }

    public void setQuizCreer(List<Quiz> quizCreer) {
        this.quizCreer = quizCreer;
    }


//construteur
    public Utilisateur() {


    }

    public Utilisateur(long id, String pseudo, String email, List<Quiz> quizCreer) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.quizCreer = quizCreer;


    }

    public List<Participer> getParticipers() {
        return participers;
    }

    public void setParticipers(List<Participer> participers) {
        this.participers = participers;
    }


    // Association avec Quiz (pour les quiz auxquels l'utilisateur a participé)

    /*@ManyToMany(mappedBy = "utilisateur")
    private List<quiz> quizParticipes;

    // Association avec Réponse
    @OneToMany(mappedBy = "utilisateur")
    private List<reponse> reponses;*/
}

