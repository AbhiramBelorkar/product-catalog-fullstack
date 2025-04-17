package com.ecom.product.catalog.controller;

import com.ecom.product.catalog.domain.User;
import com.ecom.product.catalog.service.UserService;
import com.ecom.product.catalog.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public Map<String, String> login(@RequestBody User loginRequest){
        User user = service.findByUsername(loginRequest.getUsername());

        if (user != null && service.checkPassword(loginRequest.getPassword(), user.getPassword())) {
            // Generate JWT token
            String token = jwtUtils.generateToken(user.getUsername());

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        }
        throw new RuntimeException("Invalid credentials");
    }

}
