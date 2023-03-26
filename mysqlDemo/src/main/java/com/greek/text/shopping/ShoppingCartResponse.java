package com.greek.text.shopping;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartResponse {
    private List<ShoppingCart> allShoppingCart;
}
