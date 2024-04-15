package com.mypackage.Project03.controller;

import com.mypackage.Project03.enities.Product;
import com.mypackage.Project03.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        String status = productService.upsert(product);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer productId){
        Product productById = productService.getProductById(productId);
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProduct = productService.getAllProducts();
        return new ResponseEntity<>(allProduct , HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        String status = productService.upsert(product);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer productId){
        String status = productService.deleteProductById(productId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
