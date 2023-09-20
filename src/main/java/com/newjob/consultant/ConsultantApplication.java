package com.newjob.consultant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ConsultantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultantApplication.class, args);
	}

}
