
package org.lukosan.salix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("salix.properties")
public class SalixProperties {

	private boolean multisite = false;
	
	private List<String> scopes = new ArrayList<>(); 
	
	public Boolean isMultisite() {
		return multisite;
	}
	
	public void setMultisite(boolean multisite) {
		this.multisite = multisite;
	}

	public List<String> getScopes() {
		return scopes;
	}

	public void setScopes(List<String> scopes) {
		this.scopes = scopes;
	}
	
}