package com.greek.text.shopping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    @Override
    List<ShoppingCart> findAll();

    List<ShoppingCart> findByUserId(Integer userId);

    void deleteByUserIdAndBookId(Integer userId,Integer bookId);

    @Query(value = "SELECT IFNULL(SUM(book_price),0) as bookPrice  FROM (SELECT (SELECT (b.price) FROM books b WHERE b.book_id = sc.book_id)as book_price  FROM shopping_cart sc WHERE sc.user_id = :userId) t",nativeQuery=true)
    ISubTotalReturnType findSubTotal(Integer userId);
}
