package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.CreditCard;
import org.springframework.data.repository.CrudRepository;


import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Model.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends CrudRepository<User, Integer> {

}

