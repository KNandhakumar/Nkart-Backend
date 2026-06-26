package com.Nkart.Controller;

import com.Nkart.Model.Product;
import com.Nkart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200/")
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

    // Get single products
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }

    // Update products
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return service.updateProduct(id,product);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
    }
}
