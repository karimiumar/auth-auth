package com.umar.apps.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class SecuredService {
    
    //This is a secure method. Only authenticated users can access it.
    @PreAuthorize("authenticated")
    public String sayHelloSecured() {
        return "Hello User!!@";
    }
}
