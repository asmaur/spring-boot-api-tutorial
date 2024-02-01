package com.wanubit.tutorialapp.controller;

import com.wanubit.tutorialapp.domain.Tutorial;
import com.wanubit.tutorialapp.dto.TutorialDTO;
import com.wanubit.tutorialapp.mapper.TutorialMapper;
import com.wanubit.tutorialapp.service.CategoryService;
import com.wanubit.tutorialapp.service.TutorialService;
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
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @Autowired
    TutorialMapper mapper;

    @PostMapping("/tutorials")
    public ResponseEntity<TutorialDTO> createTutorial(@RequestBody TutorialDTO dto){
        try {
            Tutorial tutorial = tutorialService.createTutorial(mapper.toEntity(dto));
            return  new ResponseEntity<>(mapper.toDTO(tutorial), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials")
    public ResponseEntity<List<TutorialDTO>> getAllTutorials(@RequestParam(required = false) String title){
        try{
            List<Tutorial> tutorials = new ArrayList<>();

            if (title == null)
                tutorials = tutorialService.getAllTutorials();
            else
                tutorials = tutorialService.getTutorialByTitle(title);
            if (tutorials.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(tutorials.stream().map(mapper::toDTO).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<TutorialDTO> getTutorialById(@PathVariable("id") long id){
        try{
            Optional<Tutorial> tutorial = tutorialService.getTutorialById(id);
            return tutorial.map(value -> new ResponseEntity<>(mapper.toDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<TutorialDTO>> getTutorialByPublished(@RequestParam("published") boolean published){
        try {
            List<Tutorial> tutorials = tutorialService.getTutorialByPublished(published);
            if (tutorials.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(tutorials.stream().map(mapper::toDTO).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials")
    public ResponseEntity<TutorialDTO> updateTutorial(@RequestBody TutorialDTO dto){
        try {
            Tutorial tutorial = mapper.toEntity(dto);
            Tutorial updatedTutorial = tutorialService.updateTutorial(tutorial);
            return new ResponseEntity<>(mapper.toDTO(updatedTutorial), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id){
        tutorialService.deleteTutorial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
