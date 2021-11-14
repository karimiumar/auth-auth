package com.umar.apps.controller;

import com.umar.apps.dto.Foo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/foos")
public class FooController {

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String findOne(@PathVariable("id") final Long id) {
        return new Foo().toString();
    }
}
