package com.greek.text.user;

import com.greek.text.book.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue
    private Integer authorId;
    private String firstName;
    private String lastName;
    private String publisher;
    private String biography;

    @OneToMany(targetEntity = BookEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "author", referencedColumnName = "authorId")
    private List<BookEntity> books;

}
