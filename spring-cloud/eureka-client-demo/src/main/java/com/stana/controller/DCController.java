package com.stana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DCController {

    private final Logger logger = LoggerFactory.getLogger(DCController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc(HttpServletRequest request) {
        String services = "Services: " + discoveryClient.getServices() + ", Url: " + request.getRequestURL().toString();
        System.out.println(services);
        return services;
    }

    @GetMapping("/dc/delay")
    public String dcDelay(HttpServletRequest request) throws InterruptedException {
        Thread.sleep(5000L);
        String services = "Services: " + discoveryClient.getServices() + ", Url: " + request.getRequestURL().toString();
        System.out.println(services);
        return services;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        return file.getName();
    }

    @GetMapping(value = "/trace-2")
    public String trace(HttpServletRequest request) {
        String services = "Services: " + discoveryClient.getServices() + ", Url: " + request.getRequestURL().toString();
        logger.info("===<call trace-2>=== ");
        return "Trace2, "+ services;
    }
}
