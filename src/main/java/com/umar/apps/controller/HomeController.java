package com.umar.apps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "Welcome";
    }
}
