package com.learning.liquibase.Controller;

import com.learning.liquibase.Models.Product;
import com.learning.liquibase.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        try{
            return productService.create(product);
        }
        catch (Exception ex){
            throw new RuntimeException("error while creating product object");
        }

    }

}
