package dev.ashish.vaultexample;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;

import dev.ashish.vaultexample.model.Credential;
import dev.ashish.vaultexample.model.CredentialsService;
import dev.ashish.vaultexample.model.DatabaseConfig;

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

		logger.info("Username: "+credential.getUsername());
		logger.info("Password: "+credential.getPassword());
		
		
	}
	

}
