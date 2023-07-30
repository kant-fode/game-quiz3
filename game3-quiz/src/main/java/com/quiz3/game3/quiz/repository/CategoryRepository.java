package com.quiz3.game3.quiz.repository;

import com.quiz3.game3.quiz.modele.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
