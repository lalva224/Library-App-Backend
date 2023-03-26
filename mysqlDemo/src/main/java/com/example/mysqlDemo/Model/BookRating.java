package com.example.mysqlDemo.Model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class BookRating
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    @JoinColumn(name = "rated_by_user", referencedColumnName = "username")
    private User ratedByUser;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateRated;
    private int rating;

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRatedByUser(User user)
    {
        ratedByUser = user;
    }

    public User getRatedByUser()
    {
        return ratedByUser;
    }

    public void setDateRated(LocalDate date)
    {
        dateRated = date;
    }

    public LocalDate getDateRated()
    {
        return dateRated;
    }

}
