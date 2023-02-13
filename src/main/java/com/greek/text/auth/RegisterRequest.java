package com.greek.text.auth;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.greek.text.user.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String name;
  private String picture;
  private String address;
  private String homeAddress;
  private String email;
  private String password;
  private List<Role> roles;
}
