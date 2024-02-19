package com.fatma.ecommerce.controller;

import com.fatma.ecommerce.model.entity.Order;
import com.fatma.ecommerce.model.entity.Product;
import com.fatma.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder/{userId}")
    public ResponseEntity<?> addOrder(@PathVariable int userId){
        return orderService.addOrder(userId);
    }
@PutMapping("/updateOrder")
    public ResponseEntity<?> updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }
@GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }
@GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrders(){
        return orderService.getAllOrders();

    }
@DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable int id){
        return orderService.deleteOrderById(id);

    }
    @DeleteMapping("deleteAllOrders")

    public  ResponseEntity<?> deleteAllOrders(){
        return orderService.deleteAllOrders();

    }

}
