package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.CategoryRepository;
import com.quiz3.game3.quiz.modele.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Categoryservice {

    @Autowired
    private CategoryRepository categorydao;

    public Category creer(Category category) {
        return categorydao.save(category);
    }

    public List<Category> lire() {
        return categorydao.findAll();
    }

    public Category modifier(Long id, Category category) {
        return categorydao.findById(id).map(c -> {
            c.setTitre(category.getTitre());
            c.setDescription(category.getDescription());
            return categorydao.save(c);
        }).orElseThrow(() -> new RuntimeException("categorie introuvable : " + id));
    }

    public String supprimer(Long id) {
        categorydao.deleteById(id);
        return "Suppression effectuée !";
    }
}
