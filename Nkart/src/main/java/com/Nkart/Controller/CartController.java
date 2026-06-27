package com.Nkart.Controller;

import com.Nkart.Model.Cart;
import com.Nkart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartService cartService;

    // Add product to cart
    @PostMapping
    public Cart addToCart(@RequestBody Cart cart){
        return this.cartService.addToCart(cart);
    }

    // Get cart items by user email
    @GetMapping("/{userEmail}")
    public List<Cart> getCartItems(@PathVariable String userEmail){
        return this.cartService.getCartItems(userEmail);
    }

    // Remove item from cart
    @DeleteMapping("/{id}")
    public void removeCartItem(@PathVariable Long id){
        this.cartService.removeCartItem(id);
    }
}
