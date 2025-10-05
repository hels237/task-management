package com.k48.Gestion.des.taches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestionDesTachesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesTachesApplication.class, args);
	}
}
