package com.Nkart.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {

    private Long id;
    private Long productId;
    private String productName;
    private Double price;
    private String imgUrl;
    private Integer quantity;
}
