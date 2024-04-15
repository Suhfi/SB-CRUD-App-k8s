package com.mypackage.Project03.services;

import com.mypackage.Project03.enities.Product;
import com.mypackage.Project03.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public String upsert(Product product) {    //upsert (insert/update), save() is an upsert method.
        productRepository.save(product);
        return "success";
    }

    @Override
    public Product getProductById(Integer productId) {
        //Optional objects are used to avoid null pointer exception.
        Optional<Product> productById = productRepository.findById(productId);
        if(productById.isPresent()){
            return productById.get();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    @Override
    public String deleteProductById(Integer productId) {
        if (productRepository.existsById(productId)){
            productRepository.deleteById(productId);
            return "Deleted Successfully";
        }else {
        return "No record found";
        }
    }
}
