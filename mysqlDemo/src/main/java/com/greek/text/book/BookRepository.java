package com.greek.text.book;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
    List<BookEntity>findAll();
    List<BookEntity>findByAuthor(Integer id);

    BookEntity findByIsbn(Integer isbn);

    BookEntity findByBookId(Integer bookId);

    List<BookEntity> findByGenre(String genre);

    List<BookEntity> findByOrderBySoldCopiesDesc(Pageable limit);

    @Query(value = "SELECT * FROM books bb WHERE bb.book_id IN(SELECT book_id from(SELECT AVG(br.rating) as rating,br.book_id from books_rating br GROUP by br.book_id HAVING rating >= :rating) table1)",nativeQuery = true)
    List<BookEntity>findGreaterRatingBooks(Double rating);

    @Transactional
    @Modifying
    @Query(value = "UPDATE books b SET b.price = (b.price - b.price * :discount) WHERE b.publisher = :publisher",nativeQuery = true)
    void updatePriceByPublisher(BigDecimal discount,String publisher);
}
