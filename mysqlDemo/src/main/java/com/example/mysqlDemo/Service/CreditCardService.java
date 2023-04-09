package com.example.mysqlDemo.Service;


import com.example.mysqlDemo.Model.CreditCard;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.CreditCardRepo;
import com.example.mysqlDemo.Repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService {
	
	@Autowired
    CreditCardRepo creditCardRepo;
	@Autowired
	UserRepository userRepo;

    public CreditCardService(CreditCardRepo creditCardRepo, UserRepository userRepo){
        this.creditCardRepo = creditCardRepo;
        this.userRepo = userRepo;
    }

	public void addCard(String username, String nameOncard, long cardNumber, int cvc, int expiration, int zipCode) {
		// finds user by user name
		Optional<User> optionalUser = userRepo.findById(username);
		User user = optionalUser.get();
		
		// create new credit card for user
		CreditCard newCreditCard = new CreditCard();

		newCreditCard.setCardForUser(user);
		newCreditCard.setNameOncard(nameOncard);
		newCreditCard.setCardNumber(cardNumber);
		newCreditCard.setCVC(cvc);
		newCreditCard.setExpiration(expiration);
		newCreditCard.setZipCode(zipCode);
		
		// saves new card 
		creditCardRepo.save(newCreditCard);
	} 
}
