package com.stana.eurekaconsumerribbonhystrix.controller;

import com.stana.eurekaconsumerribbonhystrix.services.ConsumerService;
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

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer/delay")
    public String dcDelay() {
        return consumerService.consumerDelay();
    }

    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }
}
