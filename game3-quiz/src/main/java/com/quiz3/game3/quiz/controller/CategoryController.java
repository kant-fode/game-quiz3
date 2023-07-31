package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.modele.Category;
import com.quiz3.game3.quiz.service.Categoryservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")

public class CategoryController {

    private final Categoryservice categoryservice;

    public CategoryController(Categoryservice categoryservice){
        this.categoryservice = categoryservice;
    }

    @PostMapping("/creer")
    public Category creer(@RequestBody Category category){
        return categoryservice.creer(category);
    }
    @GetMapping("")
    public List<Category> list(){
        return categoryservice.rechercher();
    }
    @PutMapping("/modifier/{id}")
    public Category modifier(@PathVariable Long id, @RequestBody Category category){
        return categoryservice.modifier(id,category);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id){
        return categoryservice.supprimer(id);
    }

}
