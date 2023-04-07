package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.CreditCard;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditCardRepo extends CrudRepository<CreditCard, String> {


}