package com.fatma.ecommerce.service;

import com.fatma.ecommerce.exception.RecordNotFoundException;
import com.fatma.ecommerce.model.entity.Cart;
import com.fatma.ecommerce.model.entity.Order;
import com.fatma.ecommerce.model.entity.Product;
import com.fatma.ecommerce.model.entity.User;
import com.fatma.ecommerce.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserService userService;
    @Autowired
   private ProductService productService;
    @Autowired
    private  CartService cartService;

    public ResponseEntity<?> addOrder(int userId){
        User user=userService.getUserById(userId);

        if(user.getOrder()==null){
            user.setOrder(new ArrayList<>());
        }

        Cart cartAllFields=cartService.getCartById(user.getCart().getId());
      Order order=new Order();
      order.setUser(user);
     order.setProducts(new ArrayList<>(cartAllFields.getProducts()));
     order.setTotalAmount(order.getProducts().size());
        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.CREATED);

    }
    public ResponseEntity<?> updateOrder(Order order){
      Order exisitOrder=  checkOrderIsExistOrThrowException(order.getId());
      order.setOrderCreated(exisitOrder.getOrderCreated());
      order.setProducts(exisitOrder.getProducts());

        return new ResponseEntity<>(orderRepo.save(order),HttpStatus.ACCEPTED);

    }
    public Order getOrderById(int id){
        Order order=orderRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this record with " + id +" not found")
        );
        return order;
    }
    public ResponseEntity<?> getAllOrders(){
      List<Order> orders=orderRepo.findAll();
      if(!orders.isEmpty()&&orders!=null){
          return  new ResponseEntity<>(orders,HttpStatus.FOUND);
      }
      else
          throw new RecordNotFoundException("this records not found");

    }
    public ResponseEntity<?> deleteOrderById(int OrderId ){
        checkOrderIsExistOrThrowException(OrderId);
        orderRepo.deleteById(OrderId);
        return new ResponseEntity<>("order has been Successfully Deleted ",HttpStatus.OK);
    }
    public  ResponseEntity<?> deleteAllOrders(){
        orderRepo.deleteAll();
        return new ResponseEntity<>("All Orders have been Successfully Deleted ",HttpStatus.OK);

    }



    public Order checkOrderIsExistOrThrowException(int id){
         return getOrderById(id);

    }


}
