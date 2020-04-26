package dev.ashish.vaultexample.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@ConfigurationProperties("example")
public class DatabaseConfig {

	private String username;
	private String password;
	
}
