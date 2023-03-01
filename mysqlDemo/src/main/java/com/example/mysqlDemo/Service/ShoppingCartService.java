package com.example.mysqlDemo.Service;

import com.example.mysqlDemo.Model.Book;
import com.example.mysqlDemo.Model.ShoppingCart;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.BookRepo;
import com.example.mysqlDemo.Repo.ShoppingCartRepo;
import com.example.mysqlDemo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ShoppingCartService {
    @Autowired
    private final ShoppingCartRepo shoppingCartrepo;
    @Autowired
    private final BookRepo bookrepo;
    @Autowired
    private final UserRepository userRepo;

    public ShoppingCartService(ShoppingCartRepo shoppingCartrepo, BookRepo bookrepo, UserRepository userRepository){
        this.shoppingCartrepo =shoppingCartrepo;
        this.bookrepo= bookrepo;
        this.userRepo= userRepository;
    }

    //http methods
    public String addtoCart(int bookId, int userId){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(getUser(userId));
        shoppingCart.addBook(getBook(userId));
        shoppingCartrepo.save(shoppingCart);
        return "added";
    }
    public String removeFromCart(int bookId, int userId){
        Optional<ShoppingCart> cart= shoppingCartrepo.findById(userId);
        ShoppingCart cartItems = cart.orElse(new ShoppingCart());
        List<Book> books = cartItems.getBooks();
        books.remove(getBook(bookId));
        cartItems.setBooks(books);

        shoppingCartrepo.save(cartItems);

        return "removed";

    }
    public Optional<ShoppingCart> retrieveBook(int userId){
        return shoppingCartrepo.findById(userId);
    }
    public double retrievePrice(int userId){
        List<Book> books = getBooksFromCart(userId);
        double price = 0;

        for(Book b : books){
            price+= b.getPrice();
        }

        return price;
    }

    // helper methods
    public List<Book> getBooksFromCart(int userId){
        Optional<ShoppingCart> cart= shoppingCartrepo.findById(userId);
        ShoppingCart cartItems = cart.orElse(new ShoppingCart());
        List<Book> books = cartItems.getBooks();
        return books;
    }

    public Book getBook(int bookId){
        Optional<Book> optionalBook = findBook(bookId);
        Book book = optionalBook.orElse(new Book());
        return book;
    }
    public User getUser(int userId){
        Optional<User> optionalUser = findUser(userId);
        User user = optionalUser.orElse(new User());
        return user;
    }
    public Optional<Book> findBook(int bookId){
        return bookrepo.findById(bookId);

    }
    public Optional<User> findUser(int userId){
        return userRepo.findById(userId);
    }
}
