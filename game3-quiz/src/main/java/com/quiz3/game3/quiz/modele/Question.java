package com.quiz3.game3.quiz.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    // Relation OneToMany avec les réponses de la question
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Reponse> reponses;

    public Question() {
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
}
