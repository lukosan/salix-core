package org.lukosan.salix;

import java.util.Map;

public interface SalixResource extends SalixScoped {

	String getSourceId();
	
	String getSourceUri();
	
	Map<String, Object> getMap();
	
}