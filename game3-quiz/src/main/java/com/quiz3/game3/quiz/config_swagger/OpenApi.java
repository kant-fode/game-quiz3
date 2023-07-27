package com.quiz3.game3.quiz.config_swagger;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
    @Configuration
    public class OpenApi {

        @Bean
        public OpenAPI usersMicroserviceOpenAPI() {
            return new OpenAPI()
                    .info(new Info().title("APi Swagger")
                            .description("Your API Description")
                            .version("1.0"));
        }
    }

