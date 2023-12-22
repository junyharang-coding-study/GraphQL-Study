package com.junyharangstudy.kotlingraphqltest.common.config;

@org.springframework.context.annotation.Configuration
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0017\u00a8\u0006\u0007"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/common/config/SwaggerConfig;", "", "()V", "openAPI", "Lio/swagger/v3/oas/models/OpenAPI;", "springdocVersion", "", "kotlin-graphql-test"})
public class SwaggerConfig {
    
    public SwaggerConfig() {
        super();
    }
    
    @org.springframework.context.annotation.Bean
    @org.jetbrains.annotations.NotNull
    public io.swagger.v3.oas.models.OpenAPI openAPI(@org.springframework.beans.factory.annotation.Value(value = "${springdoc.swagger-ui.version}")
    @org.jetbrains.annotations.NotNull
    java.lang.String springdocVersion) {
        return null;
    }
}