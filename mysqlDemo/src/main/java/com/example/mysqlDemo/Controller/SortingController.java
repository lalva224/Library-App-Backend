package com.example.mysqlDemo.Controller;

import java.util.concurrent.Future;
import java.util.List;

import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mysqlDemo.Modals.Book;
import com.example.mysqlDemo.Service.BookSortingRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/sorting")
public class SortingController<E> {
    @Autowired
    private BookSortingRepository bookRepo;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewBook (@RequestParam String isbn, @RequestParam String name,
    @RequestParam String description, @RequestParam double price, @RequestParam String authorName, @RequestParam String genre, @RequestParam String publisher, @RequestParam int yearPublished, @RequestParam int copiesSold, @RequestParam double rating) {
        

        Book book = new Book();
        book.setIsbn(isbn);
        book.setName(name);
        book.setDescription(description);
        book.setPrice(price);
        book.setAuthorName(authorName);
        book.setGenre(genre);
        book.setPublisher(publisher);
        book.setYearPublished(yearPublished);
        book.setCopiesSold(copiesSold);
        book.setRating(rating);
        bookRepo.save(book);
        return "Book has been Saved";
    }

    @GetMapping(path="/getByGenre")
    public  @ResponseBody  Future<List<Book>> getByGenre( @RequestParam(name = "bookGenre") String bookGenre) {  
      Future<List<Book>> booksByGenre = bookRepo.findByGenre(bookGenre);
      return booksByGenre;
    }

    @GetMapping(path="/topSellers")
    public  @ResponseBody  Future<List<Book>> topSellers() {  
      Future<List<Book>> booksByTopSellers = bookRepo.topSellers();
      return booksByTopSellers;
    }

    @GetMapping(path="/rating")
    public  @ResponseBody  Future<List<Book>> getByRating(@RequestParam(name = "rating") double rating) {  
      Future<List<Book>> booksByRating = bookRepo.getByRating(rating);
      return booksByRating;
    }

    @PostMapping(path="/discountByPublisher")
    public  @ResponseBody String discountByPublisher(@RequestParam(name = "publisher") String publisher, @RequestParam(name = "percentDiscount") double percentDiscount) {  
      
        Future<List<Book>> getPublisherBooks = bookRepo.getPublisherBooks(publisher);
        getPublisherBooks.

        return "Saved";



    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllUsers() {
        // This returns a JSON or XML with the users
        return bookRepo.findAll();
    }
}
