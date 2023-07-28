package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private long id;
    @Column(length = 50)
    private String Titre;
    private String description;

// Association avc quiz
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Quiz> quiz = new ArrayList<>();

    public Category() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
    }

    public Category(long id, String nom, String description, Utilisateur utilisateur) {
        this.id = id;
        this.Titre = nom;
        this.description = description;

    }
}
