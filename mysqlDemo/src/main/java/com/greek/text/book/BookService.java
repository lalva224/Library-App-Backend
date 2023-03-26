package com.greek.text.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookRatingRepository bookRatingRepository;

    private final BookCommentsRepository bookCommentsRepository;

    List<BookEntity> books() {
        return this.bookRepository.findAll();
    }
    List<BookEntity> listByAuthorId(Integer id) {
        return this.bookRepository.findByAuthor(id);
    }

    BookEntity saveBook(BookEntity bookEntity) {
        return this.bookRepository.save(bookEntity);
    }
    BookEntity getByIsbn(Integer isbn)
    {
        return this.bookRepository.findByIsbn(isbn);
    }

    void ratingForBook(BooksRating booksRating)
    {
        this.bookRatingRepository.save(booksRating);
    }

    BookEntity getAllComments(Integer bookId)
    {
        return this.bookRepository.findByBookId(bookId);
    }
    void addCommentsForBooks(BooksComments booksComments)
    {
        this.bookCommentsRepository.save(booksComments);
    }

    Double avgRatingByBookId(Integer bookId)
    {
     return this.bookRatingRepository.findRatingById(bookId);
    }

    List<BookEntity> getAllBookByGenre(String genre)
    {
        return this.bookRepository.findByGenre(genre);
    }

    List<BookEntity> getTop10Seller()
    {
        Pageable pageable = PageRequest.of(0, 10); // get first 10 records

        return this.bookRepository.findByOrderBySoldCopiesDesc(pageable);
    }

    List<BookEntity> findBooksByRating(Double rating)
    {
        return this.bookRepository.findGreaterRatingBooks(rating);
    }
    void updatePriceByPublisher(BigDecimal discount, String publisher)
    {

        this.bookRepository.updatePriceByPublisher(discount.multiply(BigDecimal.valueOf(0.01)),publisher);
    }

}
