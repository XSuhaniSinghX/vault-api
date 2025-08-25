package com.vault.vault;
//this is where we start.
// This is the main application class for the Vault application.
// It uses Spring Boot to run the application.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

}
