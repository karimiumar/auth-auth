package com.umar.apps.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {
    
    @GetMapping("/employees")
    public List<String> employees() {
        return List.of("Sara", "Zara");
    }
}
