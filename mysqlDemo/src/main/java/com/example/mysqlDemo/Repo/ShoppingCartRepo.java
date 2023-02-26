package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.ShoppingCart;
import com.example.mysqlDemo.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends CrudRepository<ShoppingCart, User> {
}
