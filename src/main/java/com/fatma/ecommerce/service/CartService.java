package com.fatma.ecommerce.service;

import com.fatma.ecommerce.exception.RecordNotFoundException;
import com.fatma.ecommerce.model.entity.Cart;
import com.fatma.ecommerce.model.entity.Product;
import com.fatma.ecommerce.model.entity.User;
import com.fatma.ecommerce.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
@Autowired
    private CartRepo cartRepo;
@Autowired
private ProductService productService;

public ResponseEntity<?> addProductToCart(int cartId ,int productId){
    Cart cart=getCartById(cartId);
    Product product=productService.getProductById(productId);
    cart.getProducts().add(product);
    cart.setQuantity(cart.getProducts().size());
    return new ResponseEntity<>(cartRepo.save(cart), HttpStatus.CREATED);
}
public ResponseEntity<?> deleteProductFromCartById(int cartId,int productId){
    Cart cart=getCartById(cartId);
    Product product=productService.getProductById(productId);
   cart.getProducts().remove(product);
  cartRepo.save(cart);
    return new ResponseEntity<>("product from cart has been Successfully Deleted ",HttpStatus.OK);

}
public ResponseEntity<?> deleteAllProductFromCart(int cartId){
    Cart cart=getCartById(cartId);
    cart.getProducts().clear();
    cartRepo.save(cart);
    return new ResponseEntity<>("All products from cart have been Successfully Deleted ",HttpStatus.OK);

}
public Cart getCartById(int cartId){
   Cart cart=cartRepo.findById(cartId).orElseThrow(
           ()->new RecordNotFoundException("this Record with " + cartId + "NotFound")
   );
   return cart;
}

}
