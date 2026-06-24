package com.Nkart.Controller;

import com.Nkart.Model.Product;
import com.Nkart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // Add product
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
}
