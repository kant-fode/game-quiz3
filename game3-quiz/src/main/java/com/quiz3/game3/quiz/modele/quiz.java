package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

@Entity
@Table (name = "quiz")
public class quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String categorie;
    private String pseudo;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private utilisateur utilisateur;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo= pseudo;
    }
}
