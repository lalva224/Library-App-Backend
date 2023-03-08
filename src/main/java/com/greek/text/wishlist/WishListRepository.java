package com.greek.text.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishListEntity, Integer> {

    Long countByUserId(Integer userId);
    List<WishListEntity> findByUserId(Integer userId);

    List<WishListEntity>findByWishListId(Integer wishListId);
}
