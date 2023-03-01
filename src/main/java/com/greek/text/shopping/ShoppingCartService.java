package com.greek.text.shopping;

import jakarta.transaction.Transactional;
import jnr.ffi.annotations.In;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    List<ShoppingCart> getAllShoppingCart() {
        return this.shoppingCartRepository.findAll();
    }

    List<ShoppingCart> getListById(Integer userId) {
        return this.shoppingCartRepository.findByUserId(userId);
    }

    ShoppingCart saveCart(ShoppingCart shoppingCart) {
        return this.shoppingCartRepository.save(shoppingCart);
    }

    ISubTotalReturnType sunTotalPrice(Integer userId) {
        return this.shoppingCartRepository.findSubTotal(userId);
    }

    @Transactional
    void deleteBookFromCart(Integer userId, Integer bookId) {
        this.shoppingCartRepository.deleteByUserIdAndBookId(userId, bookId);
    }
}
