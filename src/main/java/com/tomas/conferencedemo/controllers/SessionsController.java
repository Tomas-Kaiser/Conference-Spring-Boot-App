package com.tomas.conferencedemo.controllers;

import com.tomas.conferencedemo.models.Session;
import com.tomas.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Session getSession(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session createSession(@RequestBody final Session session) {

        System.out.println("*************** SESSION ***********");
        System.out.println(session.getSessionName());
        System.out.println(session.getSessionDescription());
        System.out.println(session.getSessionLength());
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping("/{id}")
    public void delesteSession(Long id) {
        // Also need to check for children records before deleting!
        sessionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Session updateSession(@PathVariable Long id, @RequestBody final Session session) {
        // TODO: Check if all properties are field otherwise it will be a null or use patch instead
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "sessionId");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
