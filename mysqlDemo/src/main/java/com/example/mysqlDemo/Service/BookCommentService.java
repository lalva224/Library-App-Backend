package com.example.mysqlDemo.Service;

import com.example.mysqlDemo.Model.Book;
import com.example.mysqlDemo.Model.BookComment;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.BookCommentRepo;
import com.example.mysqlDemo.Repo.BookRatingRepo;
import com.example.mysqlDemo.Repo.BookRepo;
import com.example.mysqlDemo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookCommentService
{
    @Autowired
    BookRepo bookRepo;
    @Autowired
    BookCommentRepo bookCommentRepo;
    @Autowired
    UserRepository userRepository;

    public BookCommentService(BookRepo bookRepo, BookCommentRepo bookCommentRepo, UserRepository userRepository)
    {
        this.bookRepo =  bookRepo;
        this.bookCommentRepo = bookCommentRepo;
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

    public void addComment(int isbn, String username, String comment)
    {
        //find book
        Optional<Book> b = findBook(isbn);
        Book book = b.get();

        //find user
        Optional<User> u = findUser(username);
        User user = u.get();

        //generate today's date
        LocalDate dateCommented = LocalDate.now();

        //create new BookComment and fill it with all the information
        BookComment bookComment = new BookComment();

        bookComment.setComment(comment);

        bookComment.setCommentedByUser(user);

        System.out.println(user.getName());

        bookComment.setDateCommented(dateCommented);



        //add BookComment to comments List in Book class
        book.addComment(bookComment);


        //save entities in database
        bookCommentRepo.save(bookComment);

        bookRepo.save(book);
    }

}
