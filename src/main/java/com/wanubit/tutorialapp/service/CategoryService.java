package com.wanubit.tutorialapp.service;

import com.wanubit.tutorialapp.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category createCategory(Category category);
    Optional<Category> getCategoryById(long id);
    List<Category> getAllCategories();
    List<Category> getAllCategoryByName(String name);
    Category updateCategory(Category category);
    void deleteCategory(long id);
}
