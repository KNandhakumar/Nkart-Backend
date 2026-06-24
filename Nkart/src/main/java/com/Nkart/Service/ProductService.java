package com.Nkart.Service;

import com.Nkart.Model.Product;
import com.Nkart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    // Add product
    public Product saveProduct(Product product){
        return repo.save(product);
    }

    // Get all products
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    // Get product by id
    public Product getProductById(Long id){
        return repo.findById(id).orElse(null);
    }

    // Update product
    public Product updateProduct(Long id, Product updateProduct){
        Product product = repo.findById(id).orElse(null);
        if (product != null){
            product.setName(updateProduct.getName());
            product.setDescription(updateProduct.getDescription());
            product.setPrice(updateProduct.getPrice());
            product.setImgUrl(updateProduct.getImgUrl());
            return repo.save(product);
        }
        return null;
    }

    // Delete product
    public void deleteProduct(Long id){
        repo.deleteById(id);
    }
}
