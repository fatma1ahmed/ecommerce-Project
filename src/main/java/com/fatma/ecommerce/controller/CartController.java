package com.fatma.ecommerce.controller;

import com.fatma.ecommerce.model.entity.Cart;
import com.fatma.ecommerce.model.entity.Product;
import com.fatma.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce")
public class   CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart/{cartId}/products/{productId}")
    public ResponseEntity<?> addProductToCart(@PathVariable int cartId,@PathVariable int productId){
        return cartService.addProductToCart(cartId,productId);
    }
    @DeleteMapping("/deleteCartById/{cartId}/products/{productId}")
    public ResponseEntity<?> deleteCartById(@PathVariable int cartId,@PathVariable int productId){
        return cartService.deleteProductFromCartById(cartId,productId);
    }
    @DeleteMapping("/deleteAll/{cartId}")
    public ResponseEntity<?> deleteAllProductFromCart(@PathVariable int cartId){
        return  cartService.deleteAllProductFromCart(cartId);
    }
}
