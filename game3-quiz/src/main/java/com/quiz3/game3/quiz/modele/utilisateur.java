package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

@Entity
@Table

public class utilisateur {
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
}
