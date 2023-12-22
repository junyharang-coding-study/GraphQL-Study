import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

kotlin {
    sourceSets["main"].kotlin.srcDirs("src/main/kotlin", "src/generated/querydsl")
}

plugins {
    id("org.springframework.boot") version "3.1.6"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
    kotlin("plugin.noarg") version "1.6.21"
    kotlin("kapt") version "1.7.10"
}

group = "com.JunyHarang-Study"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    //Query DSL 의존성 추가
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    implementation("com.querydsl:querydsl-sql:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

    //SpringDoc 의존성 추가
    implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")

    // 유효성 검사를 위한 의존성 추가
    implementation ("org.springframework.boot:spring-boot-starter-validation")

    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework:spring-webflux")
    testImplementation("org.springframework.graphql:spring-graphql-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder.set("paketobuildpacks/builder-jammy-base:latest")
}
