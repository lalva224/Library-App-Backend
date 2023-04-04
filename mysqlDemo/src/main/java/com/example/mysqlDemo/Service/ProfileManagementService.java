package com.example.mysqlDemo.Service;


import com.example.mysqlDemo.Model.User;
import com.example.mysqlDemo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileManagementService {
    @Autowired
    private final UserRepository userRepo;

    public ProfileManagementService(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    public String createUser(String username, String name, String email, String homeAddress, String password){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setName(name);
        user.setHomeAddress(homeAddress);
        user.setPassword(password);

        userRepo.save(user);

        return "created";
    }
}
