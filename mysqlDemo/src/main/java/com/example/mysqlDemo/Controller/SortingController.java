package com.example.mysqlDemo.Controller;

import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mysqlDemo.Modals.Book;
import com.example.mysqlDemo.Service.BookSortingRepository;


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

    @PatchMapping(path="/discountByPublisher")
    public  @ResponseBody String discountByPublisher(@RequestParam(name = "publisher") String publisher, @RequestParam(name = "percentDiscount") double percentDiscount) throws InterruptedException, java.util.concurrent.ExecutionException {  
        
       
        Future<List<Book>> getPublisherBooks =  bookRepo.getPublisherBooks(publisher);
       
        getPublisherBooks.get().forEach((b) -> {
            System.out.println(b.getId());
            System.out.println(b.getPrice());
            double newPrice = b.getPrice() * (percentDiscount / 100);
            int bookID = b.getId();
            Book book = bookRepo.findById(bookID).get();
            book.setPrice(newPrice);
            bookRepo.save(book);
        });
        return "Saved";



    }

   

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllUsers() {
        // This returns a JSON or XML with the users
        return bookRepo.findAll();
    }
}
