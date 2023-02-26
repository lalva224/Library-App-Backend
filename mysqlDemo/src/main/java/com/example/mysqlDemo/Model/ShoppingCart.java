package com.example.mysqlDemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
@Entity
public class ShoppingCart {
    @Id
    User user;
    List<Book> books;

    public User getUser() {
        return user;
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
