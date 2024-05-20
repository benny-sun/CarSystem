package com.udacity.jwdnd.c2.vehiclesapi.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vehicles API")
                        .description("This API returns a list of Car information.")
                        .version("v0.0.1")
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                        .contact(new Contact()
                                .name("Benny Sun")
                                .url("https://github.com/benny-sun")
                                .email("bennysun.dev@gmail.com"))
                );
    }
}
