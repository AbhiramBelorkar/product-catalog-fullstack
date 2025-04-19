package com.ecom.product.catalog.service;

import com.ecom.product.catalog.domain.User;
import com.ecom.product.catalog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User registerUser(User newUser){
        String encodedPassword = encoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        return repo.save(newUser);
    }

    public Optional<User> getUserByEmail(String email){
        return repo.findByEmail(email);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
