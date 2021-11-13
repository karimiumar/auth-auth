package com.umar.apps.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecuredController {
    
    @GetMapping("/public/hello")
    public List<String> publicHello() {
        return List.of("Hello", "to", "You", "from", "public");
    }
    
    @GetMapping("/private/hello")
    public List<String> privateHello() {
        return List.of("Hello", "to", "You", "from", "private");
    }
}
