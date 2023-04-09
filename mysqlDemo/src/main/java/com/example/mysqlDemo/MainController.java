package com.example.mysqlDemo;


import com.example.mysqlDemo.Model.BookComment;
import com.example.mysqlDemo.Model.ShoppingCart;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Model.CreditCard;
import com.example.mysqlDemo.Service.CreditCardService;
import com.example.mysqlDemo.Service.BookRatingService;
import com.example.mysqlDemo.Service.ShoppingCartService;
import com.example.mysqlDemo.Service.ProfileManagementService;
import com.example.mysqlDemo.Repo.BookCommentRepo;
import com.example.mysqlDemo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // This means that this class is a Controller
@RequestMapping(path="/project") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private final ShoppingCartService shoppingCartService;

    @Autowired
    private final BookRatingService bookRatingService;
    
    @Autowired
    private final ProfileManagementService profileManagementService;
    @Autowired
    private final CreditCardService creditCardService; 

   
    private final BookCommentService bookCommentService;

    public MainController(ShoppingCartService shoppingCartService, ProfileManagementService profileManagementService,
                          BookRatingService bookRatingService, BookCommentService bookCommentService, CreditCardService creditCardService){
        this.shoppingCartService = shoppingCartService;
        this.profileManagementService = profileManagementService;
        this.bookRatingService = bookRatingService;
        this.bookCommentService = bookCommentService;
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
    @PostMapping("/post/User/postCard")
    public @ResponseBody String addCard(@RequestParam String username,@RequestParam String name, @RequestParam Integer cardNumber,@RequestParam Integer cvc, @RequestParam Integer expiration,@RequestParam Integer zipCode) {
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

    @PostMapping("/post/bookComment/addComment")
    public @ResponseBody String addComment(@RequestParam String comment, @RequestParam String username, @RequestParam int isbn)
    {
        bookCommentService.addComment(isbn, username, comment);

        return "Thank you for your comment";
    }

    @GetMapping("/get/bookComment/getcomments")
    public @ResponseBody List<BookComment> getComments(@RequestParam int isbn)
    {
        return bookCommentService.getComments(isbn);
    }


}