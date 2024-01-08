package com.example.member.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Member service API 명세서",
                description = "Spring Boot 기반의 Member service API 명세서입니다.",
                version = "v1.0.0"
        )
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi customOpenAPI() {

        String[] paths = {
                "/healthcheck",
                };

        return GroupedOpenApi.builder()
                .group("member-api")
                .pathsToMatch(paths)
                .build();
    }
}
