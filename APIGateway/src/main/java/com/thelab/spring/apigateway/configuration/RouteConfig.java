package com.thelab.spring.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p-> p.path("/account/**")
//                        .filters(f -> f.rewritePath("/account/(?<segment>.*)","/account/${segment}"))
                            .filters(f -> f
                                    .filter(new TimeFilter().apply(new TimeFilter.Config()))
                                    .addResponseHeader("X-response-timestamp", LocalDateTime.now().toString())
                                    .addResponseHeader("X-response-by", "raksa")
                            )
                            .uri("lb://ACCOUNT-SERVICE")
                )
                .route(p-> p.path("/loan/**")
//                        .filters(f -> f.rewritePath("/loan/(?<segment>.*)","/loan/${segment}"))
                        .filters(f -> f
                                .filter(new TimeFilter().apply(new TimeFilter.Config()))
                                .addResponseHeader("X-response-timestamp", LocalDateTime.now().toString())
                                .addResponseHeader("X-response-by", "raksa")
                        )
                        .uri("lb://LOAN-SERVICE")
                )
                .route(p-> p.path("/customer/**")
//                        .filters(f -> f.rewritePath("/customer/(?<segment>.*)","/customer/${segment}"))
                            .filters(f -> f
                                    .filter(new TimeFilter().apply(new TimeFilter.Config()))
                                    .addResponseHeader("X-response-timestamp", LocalDateTime.now().toString())
                                    .addResponseHeader("X-response-by", "raksa")
                            )
                            .uri("lb://CUSTOMER-SERVICE")
                )
                .build();
    }
}
