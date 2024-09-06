package com.thelab.spring.loanservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @GetMapping("/balance")
    public String getTotalBalance() {
        return "owe 50$";
    }

    @GetMapping("/balance/{id}")
    public String getBalanceId(@PathVariable int id) {
        return "Loan Balance Id = " + id;
    }

    @GetMapping("/balancename")
    public String getBalanceId(@RequestParam("name") String name) {
        return "Loan Balance Name = " + name;
    }
}
