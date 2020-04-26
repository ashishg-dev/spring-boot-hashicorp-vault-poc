package dev.ashish.vaultexample.vaultconfig;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
public class DatabaseConfig extends AbstractVaultConfiguration {

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication("s.E5WAjTpdiTu02ilhPb3FdGfC");
    }

    @Override
    public VaultEndpoint vaultEndpoint() {
//        return VaultEndpoint.create("127.0.0.1", 8200);
    	
		try {
			return VaultEndpoint.from(new URI("http://127.0.0.1:8200/v1/"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
//		return new VaultEndpoint();
        
    }
    
    
 

}