package com.polytech.fast_seasonal_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FastSeasonalGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastSeasonalGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(p -> p
                .path("/api/jobseeker/**")
                .uri("http://localhost:8081")
            )
            .route(p -> p
                .path("/api/recruiter/**")
                .uri("http://localhost:8081")
            )
            .route(p -> p
                .path("/api/offer/**")
                .uri("http://localhost:8082")
            )
            .build();
    }
}
