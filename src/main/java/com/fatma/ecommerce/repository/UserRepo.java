package com.fatma.ecommerce.repository;



import com.fatma.ecommerce.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface   UserRepo extends JpaRepository<User,Integer> {
    public Optional<User> findByEmailAndPassword(String email, String password);
    public Optional<User> findByEmail(String email);

}
