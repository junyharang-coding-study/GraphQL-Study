package com.junyss.graphqltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GraphqlTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlTestApplication.class, args);
	}

}
