package com.thelab.spring.accountservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/balance")
    public String getTotalBalance() {
        return "100$";
    }

    @GetMapping("/balance/{id}")
    public String getBalanceId(@PathVariable int id) {
        return "Account Balance Id = " + id;
    }
}

