package com.tomas.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/")
    public Map getVersion() {
        Map<String, String> version = new HashMap<>();
        version.put("app-version", appVersion);
        return version;
    }
}
