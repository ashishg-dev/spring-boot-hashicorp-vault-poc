package dev.ashish.vaultexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import dev.ashish.vaultexample.model.Credential;

@SpringBootApplication
@ComponentScan
@EnableScheduling
@EnableConfigurationProperties(Credential.class)
public class SpringVaultApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(SpringVaultApplication.class);
	private Credential credential;

	public SpringVaultApplication(Credential credential) {
		this.credential = credential;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringVaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Username: " + credential.getUsername());
		logger.info("Password: " + credential.getPassword());

	}

}
