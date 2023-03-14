package com.example.mysqlDemo.Service;


import com.example.mysqlDemo.Model.CreditCard;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.CreditCardRepo;
import com.example.mysqlDemo.Repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {
	
	@Autowired
    private final CreditCardRepo creditCardRepo;

    @Autowired
    private final UserRepository userRepository;
    
    public CreditCardService(CreditCardRepo creditCardRepo, UserRepository userRepository){
        this.creditCardRepo = creditCardRepo;
        this.userRepository = userRepository;
    }   
      

}
