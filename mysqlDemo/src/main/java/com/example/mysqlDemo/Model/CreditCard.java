package com.example.mysqlDemo.Model;

import jakarta.persistence.*;
import java.util.Optional;

@Entity // This tells Hibernate to make a table out of this class
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	
	@ManyToOne
    @JoinColumn(name = "card_for_user", referencedColumnName = "username")
    private User cardForUser;
	
    private String nameOncard;
    
    private long cardNumber;
    
    private int cvc;
    
    private int expiration;
    
    private int zipCode;
    
    
    public User getCardForUser(){
    	return cardForUser;
    }
    
    public void setCardForUser(User cardForUser) {
		this.cardForUser = cardForUser;
	}
    
    public String getName() {
        return nameOncard;
    }

    public void setNameOncard(String nameOncard) {
        this.nameOncard = nameOncard;
    }
    
    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getCVC() {
        return cvc;
    }

    public void setCVC(int cvc) {
        this.cvc = cvc;
    }

	public int getExpiration() {
		return expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	

	

}
