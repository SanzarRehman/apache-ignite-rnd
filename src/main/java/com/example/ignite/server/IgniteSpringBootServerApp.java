package com.example.ignite.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class IgniteSpringBootServerApp {

	public static void main(String[] args) {
		SpringApplication.run(IgniteSpringBootServerApp.class, args
		);
	}
}
