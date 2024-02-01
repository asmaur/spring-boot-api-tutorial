package com.wanubit.tutorialapp.dto;

import com.wanubit.tutorialapp.domain.Category;

import java.time.LocalDateTime;
import java.util.Set;

public class TutorialDTO {
    private long id;
    private String title;
    private String description;
    private boolean published;
    private Set<CategoryDTO> categories;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TutorialDTO(){};

    public TutorialDTO(
            long id,
            String title,
            String description,
            boolean published,
            Set<CategoryDTO> categories,
            LocalDateTime createdAt,
            LocalDateTime updatedAt

    ){
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
        this.categories = categories;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
