package com.junyharangstudy.kotlingraphqltest.common.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(@Value("\${springdoc.swagger-ui.version}") springdocVersion: String): OpenAPI {
        return OpenAPI()
            .info(Info()
                .title("주니의 코프링 GraphQL 실습")
                .version(springdocVersion)
                .description("API 명세서"))
            .components(Components())

    }
}