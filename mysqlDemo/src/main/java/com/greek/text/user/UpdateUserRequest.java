package com.greek.text.user;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUserRequest {
    private String name;

    private String username;
    private String password;

    private String address;
    private String homeAddress;

}
