package com.stana.springweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    DiscoveryClient discoveryClient;

    private final static Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(){
        log.info("Hello world!");
        return "Hello, Home";
    }

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
