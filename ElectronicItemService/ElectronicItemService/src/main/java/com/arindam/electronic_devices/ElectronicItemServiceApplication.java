package com.arindam.electronic_devices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ElectronicItemServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ElectronicItemServiceApplication.class, args);

	}

}
