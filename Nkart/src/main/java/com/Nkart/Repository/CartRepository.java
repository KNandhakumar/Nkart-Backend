package com.Nkart.Repository;

import com.Nkart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByUserEmail(String userEmail);
}
