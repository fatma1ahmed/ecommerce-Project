package com.fatma.ecommerce.repository;

import com.fatma.ecommerce.model.entity.Cart;
import com.fatma.ecommerce.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
}
