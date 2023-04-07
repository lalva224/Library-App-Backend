package com.example.mysqlDemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class CreditCard {
	@Id
	private String Id;
	
	@OneToOne
    private User username;
	
    private String name;
    
    private Integer cardNumber;
    
    private Integer cvc;
    
    private Integer expiration;
    
    private Integer zipCode;
    
    
    public String getId(User username) {
		return username.getUsername();
	}

	public void setId(String id) {
		this.Id = id;
	}
    
    public User getUser(){
    	return username;
    }
    
    public void setUser(User username) {
		this.username = username;
	}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Integer getCVC() {
        return cvc;
    }

    public void setCVC(Integer cvc) {
        this.cvc = cvc;
    }

	public Integer getExpiration() {
		return expiration;
	}

	public void setExpiration(Integer expiration) {
		this.expiration = expiration;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	

	

}
