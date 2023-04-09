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
    private final CreditCardRepo creditCardRepo;
	private final UserRepository userRepo;

    public CreditCardService(CreditCardRepo creditCardRepo, UserRepository userRepo){
        this.creditCardRepo = creditCardRepo;
        this.userRepo = userRepo;
    }

    
	public String addCard(String username, String name, long cardNumber, Integer cvc, Integer expiration, Integer zipCode) {
		CreditCard newCreditCard = new CreditCard();
		newCreditCard.setUsername(username);
		newCreditCard.setName(name);
		newCreditCard.setCardNumber(cardNumber);
		newCreditCard.setCVC(cvc);
		newCreditCard.setExpiration(expiration);
		newCreditCard.setZipCode(zipCode);
		
		creditCardRepo.save(newCreditCard);

		return "saved";
	} 
	
	/*private User getUser(String username) {
		Optional<User> optionalUser = retrieveUser(username);
		User user = optionalUser.orElse(new User());
        return user;
	}


	public Optional<User> retrieveUser(String username) {
	    return userRepo.findById(username);
	}*/
	

}
