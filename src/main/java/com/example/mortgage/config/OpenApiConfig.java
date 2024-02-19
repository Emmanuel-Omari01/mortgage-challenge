package com.example.mortgage.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info =
        @Info(
            contact =
                @Contact(
                    name = "Emmanuel Mireku Omari",
                    email = "emmanuel.omari@amalitech",
                    url = "https://survey-sphere.amalitech-dev.net"),
            description = "OpenApi documentation for Mortgage Application",
            title = "Mortgage Application API Documentation",
            version = "1.0",
            license = @License(name = "License name", url = ""),
            termsOfService = "Terms of Service"),
    servers = {
      @Server(description = "Local ENV", url = "http://localhost:8080"),
      @Server(description = "PRE_PROD ENV", url = "")
    })
public class OpenApiConfig {}
