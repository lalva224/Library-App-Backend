package com.greek.text.wishlist;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListBooksRepository extends JpaRepository<WishListBooks,Integer> {
    @Transactional
    Long deleteByBookIdAndWishListId(Integer bookId,Integer wishListId);
}
