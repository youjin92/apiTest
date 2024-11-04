package com.jyou.apiTest.common.config.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "config.swagger")
public record SwaggerConfigValue(SwaggerGroupType swaggerGroupType) {
}
