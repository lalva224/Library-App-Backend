package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.WishListBooks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListBooksRepo extends JpaRepository<WishListBooks,Integer> {
    @Transactional
    Long deleteByIsbnAndWishListId(Integer isbn,Integer wishListId);
}
