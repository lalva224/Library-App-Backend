package com.example.mysqlDemo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private String homeAddress;

    private String username;

    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeAddress(String homeAddress) {this.homeAddress = homeAddress;}

    public String getHomeAddress() {return homeAddress;}

    public void setUsername(String username){this.username = username;}

    public String getUsername() {return username;}

    public void setPassword(String password) {this.password = password;}

    public String getPassword() {return password;}


}