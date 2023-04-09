package com.example.mysqlDemo.Model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class BookComment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    @JoinColumn(name = "commented_by_user", referencedColumnName = "username")
    private User commentedByUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCommented;

    private String comment;

    public User getCommentedByUser()
    {
        return commentedByUser;
    }

    public void setCommentedByUser(User commentedByUser)
    {
        this.commentedByUser = commentedByUser;
    }

    public LocalDate getDateCommented()
    {
        return dateCommented;
    }

    public void setDateCommented(LocalDate dateCommented)
    {
        this.dateCommented = dateCommented;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
