package com.example.mysqlDemo.Service;

import com.example.mysqlDemo.Model.Book;
import com.example.mysqlDemo.Model.BookRating;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.BookRatingRepo;
import com.example.mysqlDemo.Repo.BookRepo;
import com.example.mysqlDemo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookRatingService
{
    @Autowired
    BookRepo bookRepo;
    @Autowired
    BookRatingRepo bookRatingRepo;
    @Autowired
    UserRepository userRepository;
    public BookRatingService(BookRepo bookRepo, BookRatingRepo bookRatingRepo, UserRepository userRepository)
    {
        this.bookRepo =  bookRepo;
        this.bookRatingRepo = bookRatingRepo;
        this.userRepository = userRepository;
    }

    private Optional<Book> findBook(int isbn)
    {
        Optional<Book> b;

        b = bookRepo.findById(isbn);

        return b;
    }

    private Optional<User> findUser(String username)
    {
        Optional<User> u;

        u = userRepository.findById(username);

        return u;
    }

    public void addRating(int rating, String username, int isbn)
    {

        Optional<Book> book = findBook(isbn);
        Book bookRated = book.get();



        Optional<User> user = findUser(username);
        User ratedByUser = user.get();

        LocalDate dateRated = LocalDate.now();

        BookRating r = new BookRating();

        r.setRating(rating);
        r.setRatedByUser(ratedByUser);
        r.setDateRated(dateRated);

        bookRated.addRating(r);

        bookRatingRepo.save(r);

        bookRepo.save(bookRated);

    }

    public String getRating(int isbn)
    {
        Optional<Book> b = findBook(isbn);
        Book book = b.get();

        if (book.getRating() == 0.0)
        {
            return null;
        }

        String rating = String.format(book.getName() + " has a rating of %.2f " + "out of 5.", book.getRating());

        return rating;
    }
}
