package com.henriquebenjamim.anotaaidesafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AnotaAiDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnotaAiDesafioApplication.class, args);
	}

}
