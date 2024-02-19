package com.fatma.ecommerce.service;

import com.fatma.ecommerce.exception.RecordNotFoundException;
import com.fatma.ecommerce.model.entity.Category;
import com.fatma.ecommerce.model.entity.Product;
import com.fatma.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryService categoryService;

    public ResponseEntity<?> addProduct(Product product){
      Category categoryWithAllFields=categoryService.getCategoryById(product.getCategory().getId());
       product.setCategory(categoryWithAllFields);

    return new ResponseEntity<>(productRepo.save(product), HttpStatus.CREATED);
    }
    public ResponseEntity<?> updateProduct(Product product){
       Product existingProduct= checkProductIsExistOrThrowException(product.getId());
        Category categoryWithAllFields=categoryService.getCategoryById(product.getCategory().getId());
        product.setCategory(categoryWithAllFields);
       product.setDateCreated(existingProduct.getDateCreated());

      //  System.out.println("From fatma this is the product "+ product );
        return new ResponseEntity<>(productRepo.save(product),HttpStatus.ACCEPTED);

    }
    public Product getProductById(int id){
        Product product=productRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this Record with " + id + "NotFound")
        );
        return  product;
    }
    public ResponseEntity<?> getAllProduct(){
      List< Product> product=productRepo.findAll();
      if(!product.isEmpty()&&product !=null){
          return new ResponseEntity<>(product,HttpStatus.FOUND);

      }
      else
          throw new RecordNotFoundException("this records not found");
    }
    public ResponseEntity<?> deleteProductById(int id){
        checkProductIsExistOrThrowException(id);
        productRepo.deleteById(id);
        return new ResponseEntity<>("product has been Successfully Deleted ",HttpStatus.OK);
    }
    public ResponseEntity<?> deleteAllProduct(){
        productRepo.deleteAll();
        return new ResponseEntity<>("All products have been Successfully Deleted ",HttpStatus.OK);

    }
    public Product checkProductIsExistOrThrowException(int id){
        return getProductById(id);
    }



}
