package com.fatma.ecommerce.controller;

import com.fatma.ecommerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/loginByAdmin")
    public ResponseEntity<?> login(String email, String password){
        return adminService.login(email,password);
    }
}
