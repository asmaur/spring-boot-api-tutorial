package com.wanubit.tutorialapp.service.impl;

import com.wanubit.tutorialapp.domain.Category;
import com.wanubit.tutorialapp.repository.CategoryRepository;
import com.wanubit.tutorialapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public Category createCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public List<Category> getAllCategoryByName(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = repository.findById(category.getId()).orElseThrow();
        existingCategory.setName(category.getName());
        return repository.save(existingCategory);
    }

    @Override
    public void deleteCategory(long id) {
        repository.deleteById(id);
    }
}
