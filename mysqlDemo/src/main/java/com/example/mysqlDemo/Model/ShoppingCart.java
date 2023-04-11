package com.example.mysqlDemo.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ShoppingCart {
    @Id
    private String username;
    @ElementCollection
    private List<Integer> isbnList = new ArrayList<Integer>();

    public void addIsbn(int bookId){
        isbnList.add(bookId);
    }
    public void removeIsbn(int bookId){
        isbnList.remove(Integer.valueOf(bookId));
    }
    public boolean isEmpty(){
        return isbnList.isEmpty();
    }

//    public int getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(int isbn) {
//        this.isbn = isbn;
//    }

    public void setUsername(String username){this.username = username;}


    public String getUsername() {
        return username;
    }



}
