package com.business.app.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class BusinessAppOne {

    @Value("${app.service.name}")
    private String serviceName;

    @Autowired
    private GreetingService greetingService;

    public static void main(String[] args) {
        SpringApplication.run(BusinessAppOne.class, args);
    }

    @GetMapping("/")
    public String greeting() {
        return serviceName;
    }

    @GetMapping("/greeting")
    public String greetingBusinessApp2() {
        return greetingService.greeting();
    }
}
