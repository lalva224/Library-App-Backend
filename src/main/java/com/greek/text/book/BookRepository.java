package com.greek.text.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
    List<BookEntity>findAll();
    List<BookEntity>findByAuthor(Integer id);

    BookEntity findByIsbn(Integer isbn);
}
