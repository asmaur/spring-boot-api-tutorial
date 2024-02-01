package com.wanubit.tutorialapp.service;

import com.wanubit.tutorialapp.domain.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {
    Tutorial createTutorial(Tutorial tutorial);
    List<Tutorial> getAllTutorials();
    Optional<Tutorial> getTutorialById(long id);
    List<Tutorial> getTutorialByTitle(String title);
    List<Tutorial> getTutorialByPublished(boolean published);
    Tutorial updateTutorial(Tutorial tutorial);
    void deleteTutorial(long id);
}
