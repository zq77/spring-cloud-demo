package com.z.apigateway;

import com.z.apigateway.filter.RequestTimeFilter;
import com.z.apigateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("config_route", r -> r.path("/**.yml")
                        .filters(f -> f.filter(new RequestTimeFilter())).uri("lb://config"))
//                .route("config_route", r -> r.path("/products**", "/api/**").uri("lb://product"))
//                .route("order_route", r -> r.path("/**").uri("lb://order"))
                .build();
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
