package com.greek.text.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserProvider {

  public Users getCurrentUser() {
    return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
}
