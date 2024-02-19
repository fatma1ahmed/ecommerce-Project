package com.fatma.ecommerce.service;

import com.fatma.ecommerce.exception.RecordNotFoundException;
import com.fatma.ecommerce.model.entity.Category;
import com.fatma.ecommerce.model.entity.Product;
import com.fatma.ecommerce.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;


    public ResponseEntity<?> addCategory(Category category){
        return new ResponseEntity<>(categoryRepo.save(category), HttpStatus.CREATED);
    }
    public ResponseEntity<?> updateCategory(Category category){
        Category existingCategory=checkIfCategoryIsExistOrThrowException(category.getId());
//        existingCategory.setName(category.getName());
//        existingCategory.setProduct(category.getProduct());
        System.out.println("From fatma this is the category "+ category );
        return new ResponseEntity<>(categoryRepo.save(category),HttpStatus.ACCEPTED);
    }
    public Category getCategoryById(int id){
     Category category=categoryRepo.findById(id)
             .orElseThrow(
                ()->new RecordNotFoundException("this Record with " + id + "NotFound")
     );

     return category;
    }

public ResponseEntity<?> getAllCategory(){
   List<Category> category=categoryRepo.findAll();
           if(!category.isEmpty()&& category!=null) {
               return new ResponseEntity<>(category, HttpStatus.FOUND);
           }
               throw new RecordNotFoundException("this records not found" );
}
public ResponseEntity<?> deleteCategoryById(int id){
        checkIfCategoryIsExistOrThrowException(id);
        categoryRepo.deleteById(id);
    return new ResponseEntity<>("category has been Successfully Deleted ",HttpStatus.OK);

}
public ResponseEntity<?> deleteAllCategory(){
        categoryRepo.deleteAll();
    return new ResponseEntity<>("All Categories have been Successfully Deleted ",HttpStatus.OK);

}

    public Category checkIfCategoryIsExistOrThrowException(int id){
      return   getCategoryById(id);
    }
}
