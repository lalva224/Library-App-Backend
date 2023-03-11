package com.example.mysqlDemo.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.example.mysqlDemo.Modals.Book;

public interface BookSortingRepository extends CrudRepository<Book, Integer> {

    @Query(value = "SELECT * FROM book WHERE genre = :bookGenre", nativeQuery = true)
    Future<List<Book>> findByGenre(@Param("bookGenre") String bookGenre);

    @Query(value = "SELECT * FROM book ORDER BY copies_sold LIMIT 10", nativeQuery = true)
    Future<List<Book>> topSellers();

    @Query(value = "SELECT * FROM book WHERE rating >= :rating", nativeQuery = true)
    Future<List<Book>> getByRating(@Param("rating") double rating);

    @Query(value = "SELECT * FROM book WHERE publisher = :publisher", nativeQuery = true)
    Future<List<Book>> getPublisherBooks(@Param("publisher") String publisher);

    

    // @Modifying
    // @Query(value = "UPDATE book SET price = '5.99' WHERE isbn = '12345678'", nativeQuery = true)
    // Future<List<Book>> updateBookPricebyId();



}
