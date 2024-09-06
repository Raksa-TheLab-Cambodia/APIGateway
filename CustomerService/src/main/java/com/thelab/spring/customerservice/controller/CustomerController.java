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
    private final WebClient.Builder webClient;

    public CustomerController(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/info")
    public Mono<String> displayBalance() {
        Mono<String> accountBalanceResponse = webClient.build().get().uri("lb://ACCOUNT-SERVICE/account/balance")
                .retrieve().bodyToMono(String.class);

        Mono<String> loanBalanceResponse = webClient.build().get().uri("lb://ACCOUNT-SERVICE/account/balance")
                .retrieve().bodyToMono(String.class);

        return Mono.zip(accountBalanceResponse, loanBalanceResponse)
                .map( response ->
                    "You have " + response.getT1() +
                    "<br>and you have loan with amount " + response.getT2()
                );
    }
}
