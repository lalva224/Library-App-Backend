package com.greek.text.shopping;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @GetMapping("/get-all-shopping-cart")
    public ResponseEntity<ShoppingCartResponse> getAllCart() {
        return ResponseEntity.ok(ShoppingCartResponse.builder().allShoppingCart(this.shoppingCartService.getAllShoppingCart()).build());
    }

    @PostMapping("/save-cart")
    public ResponseEntity<SaveResponseCart> saveCart(@RequestBody ShoppingCart shoppingCart) {
        return ResponseEntity.ok().body(SaveResponseCart.builder().isSaveshoppingCart(this.shoppingCartService.saveCart(shoppingCart)).build());
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<ShoppingCartResponse> getListByCart(@PathVariable String id) {
        return ResponseEntity.ok().body(ShoppingCartResponse.builder().allShoppingCart(this.shoppingCartService.getListById(Integer.parseInt(id))).build());
    }

    @DeleteMapping("/cart")
    public void deleteBookFromCart(@RequestParam Integer userId,@RequestParam Integer bookId) {
        try {

            this.shoppingCartService.deleteBookFromCart(userId,bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/sub-total/{id}")
    public ResponseEntity<SubTotalResponse> getSubTotalPrice(@PathVariable String id)
    {
        return ResponseEntity.ok().body(SubTotalResponse.builder().subTotal(this.shoppingCartService.sunTotalPrice(Integer.parseInt(id))).build());
    }
}
