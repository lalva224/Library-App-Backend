package com.greek.text.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRatingRepository extends JpaRepository<BooksRating,Integer> {
    @Query(value = "SELECT AVG(e.rating) FROM books_rating e WHERE e.book_id = :id" , nativeQuery = true)
    Double findRatingById(Integer id);
}
