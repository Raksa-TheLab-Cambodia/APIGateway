package com.thelab.spring.loanservice.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @GetMapping("/balance")
    public Mono<String> getTotalBalance() {
        return Mono.just("owe 50$");
    }

    @GetMapping("/balance/{id}")
    public Mono<String> getBalanceId(@PathVariable int id) {
        return Mono.just("Loan Balance Id = " + id);
    }

    @GetMapping("/balancename")
    public Mono<String> getBalanceId(@RequestParam("name") String name) {
        return Mono.just("Loan Balance Name = " + name);
    }
}
