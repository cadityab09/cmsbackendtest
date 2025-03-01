package com.clinic.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class clinicApplication {

	public static void main(String[] args) {
		System.out.println("Hospital Management ");
		SpringApplication.run(clinicApplication.class, args);

		// Load .env variables explicitly
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing()
				.load();

				System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
				System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
				System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
				System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
				System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		System.out.println("DB_HOST: " + dotenv.get("DB_HOST"));
		System.out.println("DB_PORT: " + dotenv.get("DB_PORT"));

	}

}
