package com.example.mysqlDemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "wish_list_books")
@Entity
public class WishListBooks {
    @Id
    @GeneratedValue
    private Integer wishListBookId;

    private Integer isbn;
    private Integer wishListId;

    public Integer getWishListBookId() {
        return wishListBookId;
    }

    public void setWishListBookId(Integer wishListBookId) {
        this.wishListBookId = wishListBookId;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getWishListId() {
        return wishListId;
    }

    public void setWishListId(Integer wishListId) {
        this.wishListId = wishListId;
    }
}
