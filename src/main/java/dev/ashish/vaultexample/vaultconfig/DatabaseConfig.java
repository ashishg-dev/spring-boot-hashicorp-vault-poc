package dev.ashish.vaultexample.vaultconfig;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
public class DatabaseConfig extends AbstractVaultConfiguration {

	@Value("${vault.endpoint}")
	private String endPoint;
	
	@Value("${vault.token}")
	private String token;
	
	
	@Override
	public ClientAuthentication clientAuthentication() {
		return new TokenAuthentication(token);
	}

	@Override
	public VaultEndpoint vaultEndpoint() {
		try {
//			return new VaultEndpoint(); // result => https://localhost:8200/v1/ 
			return VaultEndpoint.from(new URI(endPoint));
		} catch (URISyntaxException e) {
			System.out.println("vault endpoint exception: " + e.getMessage());
			return null;
		}

	}

}