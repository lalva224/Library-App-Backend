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
    public String addtoCart(int bookId, String username){
        ShoppingCart shoppingCart = findShoppingCart(username);

        if(shoppingCart==null) {
            ShoppingCart cart = new ShoppingCart();
            cart.setUsername(username);
            cart.addBook(findBook(bookId));
            shoppingCartrepo.save(cart);

        }
        else
        shoppingCart.addBook(findBook(bookId));
        shoppingCartrepo.save(shoppingCart);

        return "added";
    }
    public String removeFromCart(int bookId, String username){
        ShoppingCart cartItems = findShoppingCart(username);
        cartItems.removeBook(findBook(bookId));

        shoppingCartrepo.save(cartItems);
        return "removed";

    }
    public List<Book> getBooksFromCart(String username){
        Optional<ShoppingCart> cart= shoppingCartrepo.findById(username);
        ShoppingCart cartItems = cart.orElse(new ShoppingCart());
        List<Book> books = cartItems.getBooks();
        return books;
    }

    public double retrievePrice(String username){
        List<Book> books = getBooksFromCart(username);
        double price = 0;

        for(Book b : books){
            price+= b.getPrice();
        }

        return price;
    }

    // helper methods

    public Optional<ShoppingCart> retrieveBook(String username){
        return shoppingCartrepo.findById(username);
    }
    public Book findBook(int bookId){
        Optional<Book> optionalBook = bookrepo.findById(bookId);
        Book book = optionalBook.orElse(new Book());
        return book;
    }



    public ShoppingCart findShoppingCart(String username){
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartrepo.findById(username);
        ShoppingCart shoppingCart = shoppingCartOptional.orElse(new ShoppingCart());
        return shoppingCart;
    }

}
