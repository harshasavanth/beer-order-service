package com.microservice.beerorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BeerOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerOrderServiceApplication.class, args);
	}

}
