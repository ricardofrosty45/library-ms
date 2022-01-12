package com.library.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
//@ComponentScan(basePackages = {"br.com.*"})
@EnableJpaRepositories(basePackages = {"com.library.ms.repositories"})
@EntityScan(basePackages = {"com.library.ms.entities"})
@EnableRetry
public class LibraryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMsApplication.class, args);
	}

}
