package com.Nkart.Service;

import com.Nkart.Model.Cart;
import com.Nkart.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Add item to cart
    public Cart addToCart(Cart cart){
        return this.cartRepository.save(cart);
    }

    // Get cart items by user email
    public List<Cart> getCartItems(String userEmail){
        return this.cartRepository.findByUserEmail(userEmail);
    }

    // Remove cart item
    public void removeCartItem(Long id){
        this.cartRepository.deleteById(id);
    }
}
