package com.andrzej.cake;

import com.andrzej.cake.repository.CakeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The entry point of running the cake REST microservice.
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {CakeRepository.class})
public class CakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeApplication.class, args);
	}
}
