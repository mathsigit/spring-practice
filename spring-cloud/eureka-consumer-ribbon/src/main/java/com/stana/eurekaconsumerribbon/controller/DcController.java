package com.stana.eurekaconsumerribbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

//    @Autowired
//    LoadBalancerClient loadBalancerClient;

    private final Logger logger = LoggerFactory.getLogger(DcController.class);

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/consumer")
    public String dc() {
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    @GetMapping(value = "/trace-1")
    public String trace() {
        logger.info("===call trace-1===");
        return restTemplate.getForEntity("http://eureka-client/trace-2", String.class).getBody();
//        return restTemplate.getForObject("http://eureka-client/trace-2", String.class);
    }
}
