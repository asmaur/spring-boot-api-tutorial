package com.wanubit.tutorialapp.service.impl;

import com.wanubit.tutorialapp.domain.Tutorial;
import com.wanubit.tutorialapp.repository.TutorialRepository;
import com.wanubit.tutorialapp.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    TutorialRepository repository;

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return repository.save(tutorial);
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }

    @Override
    public Optional<Tutorial> getTutorialById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Tutorial> getTutorialByTitle(String title) {
        return repository.findByTitleContaining(title);
    }

    @Override
    public List<Tutorial> getTutorialByPublished(boolean published) {
        return repository.findByPublished(published);
    }

    @Override
    public Tutorial updateTutorial(Tutorial tutorial) {
        Tutorial existingTutorial = repository.findById(tutorial.getId()).orElseThrow();
        existingTutorial.setTitle(tutorial.getTitle());
        existingTutorial.setDescription(tutorial.getDescription());
        existingTutorial.setPublished(tutorial.isPublished());
        existingTutorial.setCategories(tutorial.getCategories());
        return repository.save(existingTutorial);

    }

    @Override
    public void deleteTutorial(long id) {
        repository.deleteById(id);
    }
}
