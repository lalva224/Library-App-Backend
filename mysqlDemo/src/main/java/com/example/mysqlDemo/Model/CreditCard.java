package com.example.mysqlDemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class CreditCard {

	
	//@OneToOne
    private String username;
	
    private String name;
    @Id
    private long cardNumber;
    
    private int cvc;
    
    private int expiration;
    
    private int zipCode;
    
    
   /* public String getId(User username) {
		return username.getUsername();
	}*/


    public String getUsername(){
    	return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    /*public void setUser(User username) {
		this.username = username;
	}*/
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
