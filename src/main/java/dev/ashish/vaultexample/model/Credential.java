package dev.ashish.vaultexample.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("creds")
public class Credential {

	private String username;
	private String password;
	
}
