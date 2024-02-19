package com.fatma.ecommerce.controller;


import com.fatma.ecommerce.model.entity.User;
import com.fatma.ecommerce.service.EmailService;
import com.fatma.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.register(user);
        String message = "welcome, " + user.getFirstName() + " to ecommerce website  ";
        emailService.sendEmail(user.getEmail(), "this is subject", message);
        return ResponseEntity.ok("Success");

    }

    @PostMapping("/loginByUsers")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);

    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);

    }
}
