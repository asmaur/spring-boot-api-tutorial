package com.wanubit.tutorialapp.controller;

import com.wanubit.tutorialapp.domain.Category;
import com.wanubit.tutorialapp.dto.CategoryDTO;
import com.wanubit.tutorialapp.mapper.CategoryMapper;
import com.wanubit.tutorialapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper mapper;

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto){
        Category category = mapper.toEntity(dto);
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(mapper.toDTO(createdCategory), HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(@RequestParam(required = false) String name){
        try {
            List<Category> categories = new ArrayList<>();

            if(name == null)
                categories = categoryService.getAllCategories();
            else
                categories = categoryService.getAllCategoryByName(name);
            if (categories.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(categories.stream().map(mapper::toDTO).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("id") long id){
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(value -> new ResponseEntity<>(mapper.toDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO dto){
        Category updatedCategory = categoryService.updateCategory(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDTO(updatedCategory), HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") long id){
        try {
            categoryService.deleteCategory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
