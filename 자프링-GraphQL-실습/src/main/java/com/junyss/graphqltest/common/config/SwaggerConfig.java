package com.junyss.graphqltest.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI (@Value("${springdoc.swagger-ui.version}") String springdocVersion) {
		Info info = new Info()
			.title("주니의 자프링 GraphQL 실습")
			.version(springdocVersion)
			.description("API 명세서");

		return new OpenAPI()
			.components(new Components())
			.info(info);
	}
}
