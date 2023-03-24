package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;

public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
