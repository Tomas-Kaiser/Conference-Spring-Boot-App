package com.tomas.conferencedemo.controllers;

import com.tomas.conferencedemo.models.Speaker;
import com.tomas.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getAllSpeakers() {
        return speakerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Speaker getSpeaker(@PathVariable Long id) {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker createSpeaker(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping("/{id}")
    public void deleteSpeaker(@PathVariable Long id) {
        // Also need to check for children records before deleting!
        speakerRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Speaker updateSpeaker(@PathVariable Long id, @RequestBody final Speaker speaker) {
        // TODO: Check if all properties are field otherwise it will be a null or use patch instead
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speakerId");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
