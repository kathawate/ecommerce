package com.kathawate.ecommerce.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcommerceController {

    @GetMapping("/api/hello")
    public String getMessage() {
        return "Hello, Ecommerce Backend is running!";
    }
}
