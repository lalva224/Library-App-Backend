package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.Book;
import com.example.mysqlDemo.Model.ShoppingCart;
import com.example.mysqlDemo.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.Future;

@Repository
public interface ShoppingCartRepo extends CrudRepository<ShoppingCart, String> {
    @Query(value = "SELECT isbn_list FROM shopping_cart_isbn_list WHERE shopping_cart_username = :username",nativeQuery = true)
    Future<List<Integer>> getBooksByUsername(@Param("username") String username);


}
