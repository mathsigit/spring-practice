package com.stana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    private final static Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String homeRoot() {
        return "Home";
    }

    //    @GetMapping("/home")
    @RequestMapping("/home")
    public String home() {
        String username = "Test";
        log.info("Hello, " + username);
        return "Hello, " + username;
    }
}
