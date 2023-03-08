package com.greek.text.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue
    private Integer bookId;
    private String name;
    private String description;
    private Double price;
    private Integer author;
    private String genre;
    private String publisher;
    private Integer year;
    private String published;
    private Integer soldCopies;
    private Integer isbn;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(targetEntity = BooksComments.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId",referencedColumnName = "bookId")
    List<BooksComments> comments;
}
