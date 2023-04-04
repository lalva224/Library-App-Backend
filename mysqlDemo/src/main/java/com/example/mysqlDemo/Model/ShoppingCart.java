package com.example.mysqlDemo.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ShoppingCart {
    @Id
    private String username;
    @OneToOne
    private User user;
    @OneToMany
    private List<Book> books = new ArrayList<>();


    public void setUsername(String username){this.username = username;}

    public void addBook(Book book){
       books.add(book);
    }

    public void setBooks(List<Book> book){
        this.books = book;
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public List<Book> getBooks(){
        return books;
    }


}
