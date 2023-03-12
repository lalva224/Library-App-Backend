package com.example.mysqlDemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class BookRating {
    @Id
    private int id;
    @OneToOne
    private User ratedByUser;
    @OneToOne
    private Book book;
    private int rating;

    public BookRating(User user, Book book, int rating)
    {
        ratedByUser = user;
        this.book = book;
        this.rating = rating;
    }

    public int getRating()
    {
        return rating;
    }


}
