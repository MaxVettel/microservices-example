package com.business.app.one;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("business-app-2")
public interface GreetingService {

    @GetMapping("/greeting")
    String greeting();
}
