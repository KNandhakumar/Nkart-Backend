package com.Nkart.Service;

import com.Nkart.Entity.Product;
import com.Nkart.Exception.ProductNotFoundException;
import com.Nkart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Add products
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // Get product by id
    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with this id : " + id));
    }

    // Update products
    public Product updateProduct(Long id,Product newProduct){
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with this id : " + id));

        if (product != null){
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            product.setImageUrl(newProduct.getImageUrl());
            return productRepository.save(product);
        }
        return null;
    }

    // Delete products
    public ResponseEntity<?> deleteProducts(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with this id : " + id));
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
