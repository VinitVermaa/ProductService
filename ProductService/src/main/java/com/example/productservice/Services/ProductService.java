package com.example.productservice.Services;

import com.example.productservice.Models.Product;
import com.example.productservice.exceptions.InvalidProductIdException;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;
    List<Product> getAllProducts();

    Product updateProduct();
    Product replaceProduct(Long id, Product product);


    void deleteProduct();



}
