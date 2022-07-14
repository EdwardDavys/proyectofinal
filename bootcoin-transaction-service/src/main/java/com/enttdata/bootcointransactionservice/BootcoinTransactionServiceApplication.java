package com.enttdata.bootcointransactionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BootcoinTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcoinTransactionServiceApplication.class, args);
	}

}
