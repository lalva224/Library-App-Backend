package com.greek.text.wishlist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WishListController {

    private final WishListService wishListService;


    @PostMapping("/add-wishlist")
    public void createWishList(@RequestBody WishListEntity addItemInWishListRequest) {

        this.wishListService.saveWishList(addItemInWishListRequest);
    }

    @PostMapping("/add-book-in-wishlist")
    public void addBookInWishList(@RequestBody WishListBooks wishListBooks) {
        this.wishListService.addBookInWishList(wishListBooks);
    }

    @DeleteMapping("/delete-by-bookId-and-wishlistId")
    public void deleteBookByBookIdAndWishListId(@RequestBody WishListBooks wishListBooks)
    {
        this.wishListService.deleteBookByBookIdAndWishListId(wishListBooks.getBookId(),wishListBooks.getWishListId());
    }

    @GetMapping("/list-books-by-wishlist-id/{wishlistId}")
    public List<WishListEntity> listOfBooksInWishList(@PathVariable String wishlistId)
    {

        return this.wishListService.getBookListByWishList(Integer.parseInt(wishlistId));
    }
}
