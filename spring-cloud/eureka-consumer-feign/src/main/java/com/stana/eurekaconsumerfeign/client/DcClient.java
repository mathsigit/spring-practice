package com.stana.eurekaconsumerfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client")//eureka-client is an application name
public interface DcClient {

    /*
    "/dc" is the url which you want to map of "eureka-client"
     */
    @GetMapping("/dc")
    String consumer();
}
