package com.kathawate.ecommerce.controller;

import com.kathawate.ecommerce.dto.AuthRequest;
import com.kathawate.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @GetMapping("/api/hello")
    public String getMessage() {
        return "Hello, Ecommerce Backend is running!";
    }

    @Autowired
    AuthService authService;


    @PostMapping("/firebase")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {
        String token = request.getToken();

        return authService.authenticate(token);
    }

}
