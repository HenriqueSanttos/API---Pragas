package com.api_pragas;

import javax.persistence.Column;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api_pragas.domain.Pragas;
import com.api_pragas.repository.IPragasRepository;

@SpringBootApplication
public class ApiPragasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPragasApplication.class, args);
		System.out.println("porta: 1805");
		
		
	}

}
