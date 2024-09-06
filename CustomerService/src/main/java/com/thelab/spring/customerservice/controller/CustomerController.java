package com.thelab.spring.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final RestTemplate restTemplate;

    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/info")
    public String displayBalance() {
        String balanceServiceUrl = "http://Account-Service/account/balance";
        String loanServiceUrl = "http://Loan-Service/loan/balance";
        return "You have " + restTemplate.getForObject(balanceServiceUrl, String.class) +
                "<br>and you have loan with amount " + restTemplate.getForObject(loanServiceUrl, String.class) ;
    }
}
