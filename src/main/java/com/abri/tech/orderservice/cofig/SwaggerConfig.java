package com.abri.tech.orderservice.cofig;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Restaurant-Order")
                .packagesToScan("com.abri.tech.orderservice.controller")
                .pathsToMatch("/restaurant/v2.*")
                .build();
    }
}
