package com.job.jobbasket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JobBasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobBasketApplication.class, args);
	}

}
