package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Long id;
    @Column(length = 50)
    private String categorie;
    @Column(length = 50)
    private String tritre;

//association avc  utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private  Utilisateur utilisateur;
//getter & setters
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    public String getTritre() {
        return tritre;
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


    public Quiz() {
    }
    public void setTritre(String tritre) {
        this.tritre = tritre;
    }
    public Quiz(Long id, String categorie, String tritre, Utilisateur utilisateur) {
        this.id = id;
        this.categorie = categorie;
        this.tritre = tritre;
        this.utilisateur = utilisateur;


}

}