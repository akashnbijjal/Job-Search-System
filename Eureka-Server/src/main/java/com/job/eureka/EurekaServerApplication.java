package com.job.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	// 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
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
