package com.mypackage.Project03.services;

import com.mypackage.Project03.enities.Product;

import java.util.List;

public interface ProductService {
public String upsert(Product product);
public Product getProductById(Integer productId);
public List<Product> getAllProducts();
public String deleteProductById(Integer productId);
}
