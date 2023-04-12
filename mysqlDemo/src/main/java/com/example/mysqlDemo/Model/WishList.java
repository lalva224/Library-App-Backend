package com.example.mysqlDemo.Model;

import jakarta.persistence.*;


import java.util.List;


@Table(name = "wish_list")
@Entity
public class WishList {
    @Id
    @GeneratedValue
    private Integer wishListId;
    private Integer userId;
    private String wishListName;

    @OneToMany(targetEntity = WishListBooks.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "wishListId", referencedColumnName = "wishListId")
    private List<WishListBooks> books;

    public Integer getWishListId() {
        return wishListId;
    }

    public void setWishListId(Integer wishListId) {
        this.wishListId = wishListId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWishListName() {
        return wishListName;
    }

    public void setWishListName(String wishListName) {
        this.wishListName = wishListName;
    }

    public List<WishListBooks> getBooks() {
        return books;
    }

    public void setBooks(List<WishListBooks> books) {
        this.books = books;
    }
}
