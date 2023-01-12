package com.api.daylog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DayLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayLogApplication.class, args);
	}

}
