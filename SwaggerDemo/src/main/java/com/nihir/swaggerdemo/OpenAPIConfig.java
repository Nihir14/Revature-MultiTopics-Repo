package com.nihir.swaggerdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "User Management REST API",
                version = "1.0",
                description = "Complete REST API documentation using SpringSoc OpenAPI",
                contact = @Contact(
                        name = "Nihir",
                        email = "nihir@gmail.com"
                )
        )
)
public class OpenAPIConfig {
}
