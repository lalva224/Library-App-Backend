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


	public String addCard(String username, String nameOncard, long cardNumber, int cvc, int expiration, int zipCode) {
		//String username1 = "billwill";
		Optional<User> optionalUser = userRepo.findById(username);
		System.out.println(username + "   "+ userRepo.findById(username) +"    "+optionalUser);
		
		User user = optionalUser.get();
		CreditCard newCreditCard = new CreditCard();
		//System.out.println("add card4");

		newCreditCard.setCardForUser(user);
		System.out.println(username);
		newCreditCard.setNameOncard(nameOncard);
		System.out.println(user.getName());
		newCreditCard.setCardNumber(cardNumber);
		System.out.println(cardNumber);
		newCreditCard.setCVC(cvc);
		System.out.println(cvc);

		newCreditCard.setExpiration(expiration);
		System.out.println(expiration);

		newCreditCard.setZipCode(zipCode);
		System.out.println(zipCode);

		
		creditCardRepo.save(newCreditCard);

		return "saved";
        
	} 

}
