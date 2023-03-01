package com.greek.text.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {



  private final AuthenticationService authenticationService;


  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authenticationService.register(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }
  @GetMapping("/user")
  public ResponseEntity<UserResponse> getUserByUsername(@RequestParam String userName)
  {
    System.out.println(userName);
    return ResponseEntity.ok().body(authenticationService.getUserByUsername(userName));
  }
}
