package com.student.pantry.studentPantry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.pantry.studentPantry.entity.Products;
import com.student.pantry.studentPantry.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<String> addProduct(@RequestParam String productName, @RequestParam int productQuantity, @RequestParam String productExpiryDate) {
        productService.addProduct(productName, productQuantity, productExpiryDate);
        return ResponseEntity.status(HttpStatus.OK).body("Product added successfully");
    }
}