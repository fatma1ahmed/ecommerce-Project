package com.fatma.ecommerce.controller;

import com.fatma.ecommerce.model.dto.ProductDto;
import com.fatma.ecommerce.model.entity.Product;
import com.fatma.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ecommerce")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/addProduct")
    public ResponseEntity<?>   addProduct(@RequestBody Product product){
    return productService.addProduct(product);

    }
    @PutMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProduct(){
        return productService.getAllProduct();
    }
    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable int id){
        return productService.deleteProductById(id);
    }
    @DeleteMapping("/deleteAllProducts")
    public ResponseEntity<?> deleteAllProduct(){
        return productService.deleteAllProduct();
    }





}
