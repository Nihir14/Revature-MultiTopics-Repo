package com.example.resttemplateorderservice;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        // Using the builder ensures Zipkin/Micrometer tracing filters are applied
        return builder.build();
    }

}