package com.thelab.spring.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p-> p.path("/account/**")
//                        .filters(f -> f.rewritePath("/account/(?<segment>.*)","/account/${segment}"))
                        .uri("lb://ACCOUNT-SERVICE")
                )
                .route(p-> p.path("/loan/**")
//                        .filters(f -> f.rewritePath("/loan/(?<segment>.*)","/loan/${segment}"))
                        .uri("lb://LOAN-SERVICE")
                )
                .route(p-> p.path("/customer/**")
//                        .filters(f -> f.rewritePath("/customer/(?<segment>.*)","/customer/${segment}"))
                                .uri("lb://CUSTOMER-SERVICE")
                )
                .build();
    }

}
