package dev.ashish.vaultexample.service;

import java.util.Map;

import dev.ashish.vaultexample.model.DatabaseCredential;

public interface CredentialsService {

	String secureCredentials(DatabaseCredential credentials, String orgId);
	
	Map<String, Object> accessCredentials(String orgId);
	
}
