package com.example.mysqlDemo.Model;

import jakarta.persistence.*;

import java.util.List;

import java.util.Optional;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int isbn;
    private String name;
    //private String description;
    private double price;
    private String author;
    private String genre;
    private String publisher;
    private int year;
    private int copiesSold;
    @OneToMany
    private List<BookRating> ratings;
    private double rating = 0;
    private boolean isRated = false;




    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public void addRating(User user, int rating)
    {
        BookRating b = new BookRating(user, this, rating);
        this.rating += Double.valueOf(rating);
        double d = 0;
        for(BookRating b2 : ratings)
        {
            d+= Double.valueOf(b2.getRating());
        }

        this.rating = d / Double.valueOf(ratings.size());
        this.isRated = true;
    }


}
