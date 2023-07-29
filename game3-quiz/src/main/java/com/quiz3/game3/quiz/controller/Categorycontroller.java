package com.quiz3.game3.quiz.controller;

import com.quiz3.game3.quiz.modele.Category;
import com.quiz3.game3.quiz.service.Categoryservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")

public class Categorycontroller {

    private final Categoryservice categoryservice;

    public Categorycontroller(Categoryservice categoryservice){
        this.categoryservice = categoryservice;
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category){
        return categoryservice.creer(category);
    }
    @GetMapping("")
    public List<Category> read(){
        return categoryservice.rechercher();
    }
    @PutMapping("/update/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        return categoryservice.modifier(id,category);
    }
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        return categoryservice.supprimer(id);
    }

}
