package com.jyou.apiTest.common.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@OpenAPIDefinition
@RequiredArgsConstructor
public class SwaggerConfig {

    private final SwaggerConfigValue swaggerConfigValue;

    @Bean
    public GroupedOpenApi getItemApi() {
        return switch (swaggerConfigValue.swaggerGroupType()) {
            case K_CUSTOM ->
                    GroupedOpenApi
                            .builder()
                            .group("api-custom")
                            .pathsToMatch(
                                    "/api/v1/vms/log/**",
                                    "/api/v1/tasks/**",
                                    "/api/v1/devices/logs",
                                    "/api/v1/dashboard/**",
                                    "/api/v1/admins/**")
                            .build();
            default ->
                    GroupedOpenApi
                            .builder()
                            .group("api")
                            .pathsToMatch("/api/**")
                            .build();
        };
    }

/*    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("sample application API")
                        .version(appVersion)
                        .description(appDesciption)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", securityScheme()))
                .security(Collections.singletonList(securityRequirement()));
    }

    private SecurityScheme securityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER).name("Authorization");
    }

    private SecurityRequirement securityRequirement() {
        return new SecurityRequirement().addList("bearerAuth");
    }*/
}
