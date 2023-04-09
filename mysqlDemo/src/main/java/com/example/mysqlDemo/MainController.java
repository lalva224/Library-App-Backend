package com.example.mysqlDemo;


import com.example.mysqlDemo.Model.ShoppingCart;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Service.CreditCardService;
import com.example.mysqlDemo.Service.BookRatingService;
import com.example.mysqlDemo.Service.ShoppingCartService;
import com.example.mysqlDemo.Service.ProfileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // This means that this class is a Controller
@RequestMapping("/project") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private final ShoppingCartService shoppingCartService;

    @Autowired
    private final BookRatingService bookRatingService;
    
    @Autowired
    private final ProfileManagementService profileManagementService;
    @Autowired
    private final CreditCardService creditCardService; 

    public MainController(ShoppingCartService shoppingCartService, ProfileManagementService profileManagementService,
                          BookRatingService bookRatingService, CreditCardService creditCardService){
        this.shoppingCartService = shoppingCartService;
        this.profileManagementService = profileManagementService;
        this.bookRatingService = bookRatingService;
        this.creditCardService = creditCardService;
    }
    
    @PostMapping("/post/User/postUser")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String homeAddress, @RequestParam String username, @RequestParam String password) {
    	return profileManagementService.addUser(name, email, homeAddress, username, password);
    }
    @GetMapping("/get/User/getUser")
    public @ResponseBody  User getUser(@RequestParam String username){
    	return profileManagementService.getUser(username);
    	
    }
    @PutMapping("put/User/putUser")
    public @ResponseBody String updateUser(@RequestParam String username, @RequestParam String name, @RequestParam String email, @RequestParam String homeAddress, @RequestParam String password) {
    	return profileManagementService.updateUser(username, name, homeAddress, password);
    }
    @PostMapping("/post/CreditCard/postCard")
    public @ResponseBody String addCard(@RequestParam String username,@RequestParam String name, @RequestParam long cardNumber,@RequestParam int cvc, @RequestParam int expiration,@RequestParam int zipCode) {
    	System.out.println("card");
    	return creditCardService.addCard(username, name, cardNumber, cvc, expiration, zipCode);
    }

    @PostMapping("/post/shoppingCart/addBook")
    public @ResponseBody String addBook(@RequestParam int bookId, @RequestParam String userId){
        return shoppingCartService.addtoCart(bookId,userId);

    }@GetMapping("/get/shoppingCart/getBook")
    public @ResponseBody Optional<ShoppingCart> getBooks (@RequestParam int userId){
        return shoppingCartService.retrieveBook(userId);
    }
    @GetMapping("/get/shoppingCart/getPrice")
    public @ResponseBody double getPrice(@RequestParam int userId){
        return shoppingCartService.retrievePrice(userId);
    }
    @DeleteMapping("delete/shoppingCart/remove")
    public @ResponseBody String removeFromCart(int bookId, int userId){
        return shoppingCartService.removeFromCart(bookId,userId);
    }

    @PostMapping("/post/bookRating/addRating")
    public @ResponseBody String addRating(@RequestParam int rating, @RequestParam String username, @RequestParam int isbn)
    {
        if(rating > 5 || rating < 1)
        {
            return "Your rating must be between 1 and 5";
        }

        bookRatingService.addRating(rating, username, isbn);

        return "You rating of " + rating + " has been added. Thank you!";
    }

    @GetMapping("/get/bookRating/getRating")
    public @ResponseBody String getRating(@RequestParam int isbn)
    {
        if (bookRatingService.getRating(isbn) == null)
        {
            return "This book has no rating yet.";
        }

        return bookRatingService.getRating(isbn);
    }


}