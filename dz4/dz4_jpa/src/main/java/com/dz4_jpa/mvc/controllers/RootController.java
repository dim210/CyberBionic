package com.dz4_jpa.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/") // http://localhost:8080/dz4_jpa/
public class RootController {
    @GetMapping("")
    public String root() {
        return "root";
    }
}
