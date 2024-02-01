package com.wanubit.tutorialapp.mapper;

import com.wanubit.tutorialapp.domain.Tutorial;
import com.wanubit.tutorialapp.dto.TutorialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TutorialMapper {
    @Autowired
    CategoryMapper mapper;

    public TutorialDTO toDTO(Tutorial tutorial){
        TutorialDTO dto = new TutorialDTO();
        dto.setId(tutorial.getId());
        dto.setTitle(tutorial.getTitle());
        dto.setDescription(tutorial.getDescription());
        dto.setPublished(tutorial.isPublished());
        dto.setCreatedAt(tutorial.getCreatedAt());
        dto.setUpdatedAt(tutorial.getUpdatedAt());
        dto.setCategories(tutorial.getCategories().stream().map(mapper::toDTO).collect(Collectors.toSet()));

        return  dto;
    }

    public Tutorial toEntity(TutorialDTO dto){
        Tutorial tutorial = new Tutorial();
        tutorial.setId(dto.getId());
        tutorial.setTitle(dto.getTitle());
        tutorial.setDescription(dto.getDescription());
        tutorial.setPublished(dto.isPublished());
        tutorial.setCategories(dto.getCategories().stream().map(mapper::toEntity).collect(Collectors.toSet()));

        return tutorial;
    }
}
