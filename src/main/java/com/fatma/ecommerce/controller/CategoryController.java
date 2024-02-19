package com.fatma.ecommerce.controller;

import com.fatma.ecommerce.model.entity.Category;
import com.fatma.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce")
public class CategoryController {
    @Autowired
    private CategoryService  categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @PutMapping("/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }
    @GetMapping("/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @GetMapping("/getAllCategories")
    public ResponseEntity<?> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @DeleteMapping("/deleteCategoryById/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable int id){
        return categoryService.deleteCategoryById(id);
    }
    @DeleteMapping("/deleteAllCategories")
    public ResponseEntity<?> deleteAllCategory(){
        return categoryService.deleteAllCategory();
    }
}
