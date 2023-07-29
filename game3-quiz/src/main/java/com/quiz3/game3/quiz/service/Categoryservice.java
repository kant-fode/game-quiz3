package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.repository.CategoryRepository;
import com.quiz3.game3.quiz.modele.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Categoryservice {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category creer(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> rechercher() {
        return categoryRepository.findAll();
    }

    public Category modifier(Long id, Category category) {
        return categoryRepository.findById(id).map(c -> {
            c.setTitre(category.getTitre());
            c.setDescription(category.getDescription());
            return categoryRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("categorie introuvable ! " ));
    }

    public String supprimer(Long id) {
        categoryRepository.deleteById(id);
        return "Suppression effectuée !";
    }
}
