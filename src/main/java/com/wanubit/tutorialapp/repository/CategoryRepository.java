package com.wanubit.tutorialapp.repository;

import com.wanubit.tutorialapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    List<Category> findByNameContaining(String name);
}
