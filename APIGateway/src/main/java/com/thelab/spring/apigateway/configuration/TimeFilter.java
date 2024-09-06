package com.thelab.spring.apigateway.configuration;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalTime;

@Component
public class TimeFilter extends AbstractGatewayFilterFactory<TimeFilter.Config> {

    public TimeFilter() {
super(Config.class);
}

    @Override
    public GatewayFilter apply(Config config) {
    	 return (exchange, chain) -> {
             LocalTime now = LocalTime.now();
             LocalTime start = LocalTime.of(12, 0);
             LocalTime end = LocalTime.of(13, 0);

             // Check if the current time is within the restricted period
             if (now.isAfter(start) && now.isBefore(end)) {
                 // Reject the request with a 403 Forbidden status
            	 exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
                 return exchange.getResponse().setComplete().then(Mono.empty());
             }

             // Continue processing the request if it's outside the restricted period
             return chain.filter(exchange);
         };
    }

    public static class Config {

    }
}




//STATIC Gateway




















