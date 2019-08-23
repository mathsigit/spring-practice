package com.stana.eurekaconsumerfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client")//eureka-client is an application name
public interface DcClient {

    @GetMapping("/dc")
    String consumer();
}
