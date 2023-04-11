package com.example.mysqlDemo.Service;

import com.example.mysqlDemo.Model.Book;
import com.example.mysqlDemo.Model.ShoppingCart;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.BookRepo;
import com.example.mysqlDemo.Repo.ShoppingCartRepo;
import com.example.mysqlDemo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    Optional<ShoppingCart> shoppingCartOptional = shoppingCartrepo.findById(username);
     if(shoppingCartOptional.isPresent()){
         ShoppingCart shoppingCart = shoppingCartOptional.orElse(new ShoppingCart());
         shoppingCart.addIsbn(bookId);
         shoppingCartrepo.save(shoppingCart);
     }
     else{
         ShoppingCart shoppingCart = new ShoppingCart();
         shoppingCart.setUsername(username);
         shoppingCart.addIsbn(bookId);
         shoppingCartrepo.save(shoppingCart);
     }


        return "added";


    }
    public String removeFromCart(int bookId, String username){
        ShoppingCart cartItems = findShoppingCart(username);
        cartItems.removeIsbn(bookId);

        if(cartItems.isEmpty()){
            shoppingCartrepo.delete(cartItems);
        }
        else{
            shoppingCartrepo.save(cartItems);
        }

        return "removed";

    }
    public List<Book> getBooksFromCart(String username) throws ExecutionException, InterruptedException {

      Future<List<Integer>> isbns = shoppingCartrepo.getBooksByUsername(username);

      List<Book> books = new ArrayList<>();

      isbns.get().forEach((i) -> {
          Optional<Book> optionalBook =bookrepo.findById(i);
          Book book = optionalBook.orElse(new Book());
          books.add(book) ;
      });
            return books;
    }

    public double retrievePrice(String username) throws ExecutionException, InterruptedException{
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
