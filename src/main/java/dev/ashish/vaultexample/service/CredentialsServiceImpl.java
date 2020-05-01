package dev.ashish.vaultexample.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponse;

import dev.ashish.vaultexample.model.DatabaseCredential;

@Service
public class CredentialsServiceImpl implements CredentialsService {

	@Autowired
	private VaultOperations vaultTemplate;

	@Override
	public String secureCredentials(DatabaseCredential credentials, String orgId) {

		try {
			vaultTemplate.write("datasource/" + orgId, credentials);
			return "Success";

		} catch (Exception e) {
			return "someting went wrong " + e.getMessage();
		}

	}

	@Override
	public Map<String, Object> accessCredentials(String orgId) {

		try {
			VaultResponse res = vaultTemplate.read("datasource/" + orgId);
			System.out.println(res.getData());
//	        VaultResponseSupport<DatabaseConfig> response = vaultTemplate.read("datasource/"+orgId,
//    		DatabaseCredential.class);
			return res.getData();

		} catch (Exception e) {
			Map<String, Object> errorResult = new HashMap<String, Object>();
			errorResult.put("error", e.getMessage());
			return errorResult;
		}

	}

}
