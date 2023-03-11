package com.greek.text.auth;

import com.greek.text.user.CreditCardDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardRequest {
    private String username;
    private List<CreditCardDetails> cards;
}
