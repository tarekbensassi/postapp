package com.postapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PostAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostAppApplication.class, args);
	}

}
