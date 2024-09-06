package com.thelab.spring.accountservice2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/balance")
    public Mono<String> getTotalBalance() {
        return Mono.just("100$");
    }

    @GetMapping("/balance/{id}")
    public Mono<String> getBalanceId(@PathVariable int id) {
        return Mono.just("Account Balance Id = " + id);
    }
}
