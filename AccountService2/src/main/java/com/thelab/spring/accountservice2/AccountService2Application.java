package com.thelab.spring.accountservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountService2Application {

    public static void main(String[] args) {
        SpringApplication.run(AccountService2Application.class, args);
    }

}
