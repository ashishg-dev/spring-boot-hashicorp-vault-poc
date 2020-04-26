package dev.ashish.vaultexample.model;

import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;

@Service
public class CredentialsService {

	 @Autowired
	    private VaultOperations vaultTemplate;
	 
	 public void secureCredentials(DatabaseConfig credentials,String orgId) {


		 System.out.println("secureCredentials");
		 
	        vaultTemplate.write("datasources/"+orgId, credentials);
	    }
	 
	 public Map<String,Object> accessCredentials(String orgId) {

		 System.out.println("accessCredentials");
		 
		 
		 VaultResponse res =  vaultTemplate.read("datasources/"+orgId);
		 
		 
		 System.out.println(res.getData());
		 
		 
//	        VaultResponseSupport<DatabaseConfig> response = vaultTemplate.read("datasource/data/"+orgId,
//	        		DatabaseConfig.class);
	        
	        return res.getData();
	    }
	
}
