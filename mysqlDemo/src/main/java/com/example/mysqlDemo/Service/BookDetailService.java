package com.example.mysqlDemo.Service;

import com.example.mysqlDemo.Model.Author;
import com.example.mysqlDemo.Model.Book;
import com.example.mysqlDemo.Repo.AuthorRepo;
import com.example.mysqlDemo.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

@Service
public class BookDetailService {
    @Autowired
    private final BookRepo bookRepo;
    @Autowired
    private final AuthorRepo authorRepo;
    public BookDetailService(BookRepo bookRepo, AuthorRepo authorRepo){
        this.bookRepo =  bookRepo;
        this.authorRepo = authorRepo;
    }

    public String saveBook(int isbn, String name, String description, double price, int authorId, String genre, String publisher, int yearPublished, int copiesSold){
            Book book = new Book();

            book.setIsbn(isbn);
            book.setName(name);
            book.setDescription(description);
            book.setPrice(price);
            book.setAuthor(authorId);
            book.setGenre(genre);
            book.setPublisher(publisher);
            book.setYear(yearPublished);
            book.setCopiesSold(copiesSold);

            bookRepo.save(book);

            return "saved";
    }


    public Book findBook(int isbn){
        Optional<Book> optionalBook = bookRepo.findById(isbn);
        Book book = optionalBook.orElse(new Book());
        return book;
    }

    public String addAuthor(String firstName, String lastName, String biography, String publisher){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBiography(biography);
        author.setPublisher(publisher);

        authorRepo.save(author);

        return "saved";
    }

    public Future<List<Book>> getBooks(int authorId){
   return bookRepo.getBooksByAuthor(authorId);



    }


    // helper methods

    public Author findAuthor(int authorId){
        Optional<Author> authorOptional = authorRepo.findById(authorId);
        Author author = authorOptional.orElse(new Author());
        return author;
    }

}
