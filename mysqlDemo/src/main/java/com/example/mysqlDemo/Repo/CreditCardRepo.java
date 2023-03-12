package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardRepo extends CrudRepository<CreditCard,Integer> {
        }
