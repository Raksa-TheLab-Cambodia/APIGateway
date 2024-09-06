package com.thelab.spring.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class APIGatewayWithWebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(APIGatewayWithWebClientApplication.class, args);
    }

}
