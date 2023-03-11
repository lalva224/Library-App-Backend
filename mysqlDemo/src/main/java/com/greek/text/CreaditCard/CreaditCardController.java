package com.greek.text.CreaditCard;

import com.greek.text.auth.AuthenticationService;
import com.greek.text.auth.CreditCardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreaditCardController {
    private  final AuthenticationService authenticationService;
    @PostMapping("/add-credit-card")
    public void addCreditCard(@RequestBody CreditCardRequest request)
    {
        this.authenticationService.saveCreditCard(request);
        System.out.println(request);
    }
}
