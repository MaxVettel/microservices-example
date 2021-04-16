package com.business.app.two;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class BusinessAppTwo {

    @Value("${app.service.name}")
    private String serviceName;

    public static void main(String[] args) {
        SpringApplication.run(BusinessAppTwo.class, args);
    }

    @GetMapping("/")
    public String greeting() {
        return serviceName;
    }

    @GetMapping("/greeting")
    public String sayHelloToFeignClient() {
        return "Hello from Business App 2";
    }
}
