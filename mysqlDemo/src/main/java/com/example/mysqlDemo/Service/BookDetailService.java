package com.example.mysqlDemo.Service;

import com.example.mysqlDemo.Model.Book;
import com.example.mysqlDemo.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookDetailService {
    @Autowired
    BookRepo bookRepo;
    public BookDetailService(BookRepo bookRepo){
        this.bookRepo =  bookRepo;
    }

    public String saveBook(int isbn, String name, String description, double price, String author, String genre, String publisher, int yearPublished, int copiesSold ){
            Book book = new Book();
            book.setIsbn(isbn);
            book.setName(name);
            book.setDescription(description);
            book.setPrice(price);
            book.setAuthor(author);
            book.setGenre(genre);
            book.setPublisher(publisher);
            book.setYear(yearPublished);
            book.setCopiesSold(copiesSold);
            book.setRating(0);

            bookRepo.save(book);

            return "saved";
    }


    public Book findBook(int isbn){
        Optional<Book> optionalBook = bookRepo.findById(isbn);
        Book book = optionalBook.orElse(new Book());
        return book;
    }

}
