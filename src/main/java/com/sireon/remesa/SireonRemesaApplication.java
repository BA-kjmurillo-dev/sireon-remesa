package com.sireon.remesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SireonRemesaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SireonRemesaApplication.class, args);
	}

}
