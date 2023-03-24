package com.example.mysqlDemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class CreditCard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String username;
	
    private String name;
    
    private Integer cardNumber;
    
    private Integer cvc;
    
    private Integer expiration;
    
    private Integer zipCode;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void getCardNumber(Integer cardNumber) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
