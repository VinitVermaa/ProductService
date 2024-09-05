package com.example.productservice.Controllers;

import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.exceptions.ProductControllerSpecificException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
//This annotation we use to make them support (HTTP request)
@RestController
//The request coming to endpoint (/products), transfer to this controller.
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getproductbyId(@PathVariable("id") long id) throws InvalidProductIdException {
        // throw new RuntimeException("Something went wrong");
        return productService.getProductById(id);
       /* int i = 1 / 0;
        return null;*/

    }

    @GetMapping
    public List<Product> getAllproducts() {
        return productService.getAllProducts();

    }

    //create a product
    @PostMapping
    public Product createProduct(@PathVariable("id") @RequestBody Product product  ) {
        return new Product();
    }

    //partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(404));
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        return new Product();
    }


   /* @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<Void> handleproductcontrollerspecificException() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);*/
    }





