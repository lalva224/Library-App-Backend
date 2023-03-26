package com.example.mysqlDemo;


import com.example.mysqlDemo.Model.ShoppingCart;
import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Service.BookRatingService;
import com.example.mysqlDemo.Service.ShoppingCartService;
import com.example.mysqlDemo.Service.ProfileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    public MainController(ShoppingCartService shoppingCartService, ProfileManagementService profileManagementService,
                          BookRatingService bookRatingService){
        this.shoppingCartService = shoppingCartService;
        this.profileManagementService = profileManagementService;
        this.bookRatingService = bookRatingService;
    }
    
    @PostMapping("/post/User/addUser")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String homeAddress, @RequestParam String username, @RequestParam String password) {
    	return profileManagementService.addUser(name, email, homeAddress, username, password);
    }
    @GetMapping("/get/User/getUser")
    public @ResponseBody  User getUser(@RequestParam String username){
    	return profileManagementService.getUser(username);
    	
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
        bookRatingService.addRating(rating, username, isbn);

        return "You rating of " + rating + " has been added. Thank you!";
    }

    @GetMapping("/get/bookRating/getRating")
    public @ResponseBody String getRating(@RequestParam int isbn)
    {
        return bookRatingService.getRating(isbn);
    }


}