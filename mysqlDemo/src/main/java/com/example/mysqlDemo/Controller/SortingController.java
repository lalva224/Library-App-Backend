package com.example.mysqlDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mysqlDemo.Modals.Book;
import com.example.mysqlDemo.Service.BookSortingRepository;

@Controller
@RequestMapping(path="/sorting")
public class SortingController {
    @Autowired
    private BookSortingRepository bookRepo;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewBook (@RequestParam String isbn, @RequestParam String name,
    @RequestParam String description, @RequestParam double price, @RequestParam String authorName, @RequestParam String genre, @RequestParam String publisher, @RequestParam int yearPublished, @RequestParam int copiesSold) {
        

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
        bookRepo.save(book);
        return "Saved";


        // User n = new User();
        // n.setUsername(username);
        // n.setPassword(password);
        // n.setName(name);
        // n.setEmail(email);
        // n.setHomeAddress(homeAddress);
        // userRepository.save(n);
        // return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllUsers() {
        // This returns a JSON or XML with the users
        return bookRepo.findAll();
    }
}
