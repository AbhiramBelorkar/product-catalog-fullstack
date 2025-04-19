package com.ecom.product.catalog.controller;

import com.ecom.product.catalog.domain.User;
import com.ecom.product.catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User newUser){
        if(service.getUserByEmail(newUser.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("User already exists");
        }
        service.registerUser(newUser);
        return ResponseEntity.ok("User registered successfully");
    }
}
