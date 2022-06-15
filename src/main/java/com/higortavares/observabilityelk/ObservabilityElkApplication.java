package com.higortavares.observabilityelk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ObservabilityElkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservabilityElkApplication.class, args);
	}

}
