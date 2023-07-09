package com.arindam.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingServicePgApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServicePgApplication.class, args);
	}

}
