package com.greek.text.shopping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCartEntryByBookIdAndUserId {
    private ShoppingCart shoppingCart;
}
