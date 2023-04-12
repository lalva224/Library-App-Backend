package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.WishList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WishListRepo extends CrudRepository<WishList,Integer> {

    Long countByUserId(Integer userId);
    List<WishList> findByUserId(Integer userId);

    List<WishList>findByWishListId(Integer wishListId);
}
