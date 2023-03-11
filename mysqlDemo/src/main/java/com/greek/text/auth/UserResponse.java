package com.greek.text.auth;

import com.greek.text.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {

    private Optional<Users> userData;
}
