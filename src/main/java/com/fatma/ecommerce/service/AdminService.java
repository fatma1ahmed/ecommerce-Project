package com.fatma.ecommerce.service;

import com.fatma.ecommerce.exception.RecordNotCorrectException;
import com.fatma.ecommerce.model.entity.Admin;
import com.fatma.ecommerce.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
    public ResponseEntity<?> login(String email, String password){
 Admin admin=adminRepo.findByEmailAndPassword(email,password).orElseThrow(
                ()->new RecordNotCorrectException("email or password Not correct")
        );
        return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
    }
}
