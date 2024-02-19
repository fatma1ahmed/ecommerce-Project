package com.fatma.ecommerce.repository;

import com.fatma.ecommerce.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
    public Optional<Admin> findByEmailAndPassword(String email, String password);
}
