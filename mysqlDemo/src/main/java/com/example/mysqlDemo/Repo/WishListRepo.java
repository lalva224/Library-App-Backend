package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.WishList;
import org.springframework.data.repository.CrudRepository;

public interface WishListRepo extends CrudRepository<WishList,Integer> {
}
