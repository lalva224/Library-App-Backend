package com.example.mysqlDemo.Model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class ShoppingCart {
    @Id
    private int Id;
    @OneToOne
    private User user;
    @OneToMany
    private  List<Book> books;

    public User getUser() {
        return user;
    }
    /*public int getId(User user){
      return  user.getId();
    }*/
    public void setId(int id){
        this.Id= id;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void setBooks(List<Book> books){
        this.books = books;
    }
}
