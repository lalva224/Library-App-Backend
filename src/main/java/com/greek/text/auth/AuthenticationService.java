package com.greek.text.auth;

import com.greek.text.user.CreditCardDetails;
import com.greek.text.user.CreditCardDetailsRepository;
import lombok.RequiredArgsConstructor;
import com.greek.text.config.JwtService;
import com.greek.text.user.Users;

import com.greek.text.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CreditCardDetailsRepository creditCardDetailsRepository;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Users.builder()
                .name(request.getName())
                .username(request.getUsername())
                .cards(request.getCards())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(request.getRoles())
                .address(request.getAddress())
                .homeAddress(request.getHomeAddress())
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().roles(user.getRoles()).token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().roles(user.getRoles()).token(jwtToken).build();
    }

    public UserResponse getUserByUsername(String userName) {

        return UserResponse.builder().userData(userRepository.findByUsername(userName)).build();
    }

    public UserResponse updateUserByUserName(Users users) {
        Optional<Users> byUsername = userRepository.findByUsername(users.getUsername());
        Users filteredUser = (Users) byUsername.get();
        users.setId(filteredUser.getId());
        users.setEmail(filteredUser.getEmail());
        users.setUsername(filteredUser.getUsername());
        userRepository.save(users);
        return UserResponse.builder().userData(byUsername).build();
    }

    public void saveCreditCard(CreditCardRequest request) {
        Optional<Users> byUsername = userRepository.findByUsername(request.getUsername());
        Users filteredUser = (Users) byUsername.get();
        List<CreditCardDetails> creditCardDetails = request.getCards().stream().map(single -> {
            single.setUserId(filteredUser.getId());
            return single;
        }).toList();
        this.creditCardDetailsRepository.saveAll(creditCardDetails);

    }
}
