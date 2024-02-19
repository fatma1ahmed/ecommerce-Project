package com.fatma.ecommerce.service;

import com.fatma.ecommerce.exception.DuplicateRecordException;
import com.fatma.ecommerce.exception.RecordNotCorrectException;
import com.fatma.ecommerce.exception.RecordNotFoundException;
import com.fatma.ecommerce.model.entity.Cart;
import com.fatma.ecommerce.model.entity.User;
import com.fatma.ecommerce.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> register(User user){
        user.setCart(new Cart());
        Optional<User> user1= findByEmail(user.getEmail());
        if(user1.isPresent()){
            throw new DuplicateRecordException("this email already found with anther user");
        }
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);

}
    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }
    public ResponseEntity<?> login(String email, String password){
        User user=userRepo.findByEmailAndPassword(email,password).orElseThrow(
                ()->new RecordNotCorrectException("email or password Not correct")
        );
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }
    public ResponseEntity<?> getAllUsers(){
       List<User> user=userRepo.findAll();
       if(!user.isEmpty()&&user!=null){
           return new ResponseEntity<>(user,HttpStatus.FOUND);
       }
       else
           throw new RecordNotFoundException("this records not found");
    }
    public User getUserById(int id){
        User user=userRepo.findById(id).orElseThrow(

                ()->new RecordNotFoundException("this record with " + id + " not found")
        );

        return new ResponseEntity<>(user,HttpStatus.FOUND).getBody();
    }

}
