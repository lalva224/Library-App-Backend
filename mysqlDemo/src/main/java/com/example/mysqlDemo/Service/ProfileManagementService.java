package com.example.mysqlDemo.Service;

import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProfileManagementService {
	@Autowired
    private final UserRepository userRepo;
	
	public ProfileManagementService(UserRepository userRepo){
		this.userRepo = userRepo;
    }
		
	// retrieves user from database
	public User getUser(String username){
		// finds user by username
        Optional<User> optionalUser = userRepo.findById(username);
        User user = optionalUser.get();
        
        // returns user information
        return user;
    }	
	// updates existing user without updating email
	public void updateUser(String username, String name, String homeAddress, String password) {
		// finds user by username
        Optional<User> optionalUser = userRepo.findById(username);
        User updateUser = optionalUser.get();
        
        // update values
        updateUser.setHomeAddress(homeAddress);
        updateUser.setName(name);
        updateUser.setUsername(username);
        updateUser.setPassword(password);
		
        // saves updates user
		userRepo.save(updateUser);     
	}

	// adds new user to database
	public void addUser(String name, String email, String homeAddress, String username, String password ){
		// creates new user and add values

		User newUser = new User();
		newUser.setEmail(email);
		newUser.setHomeAddress(homeAddress);
		newUser.setName(name);
		newUser.setUsername(username);
		newUser.setPassword(password);
		
		// save new user
		userRepo.save(newUser);
    }

}