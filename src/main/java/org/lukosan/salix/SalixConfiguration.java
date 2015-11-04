package org.lukosan.salix;

import java.util.Map;

public interface SalixConfiguration extends SalixScoped {

	String getTarget();
	
	Map<String, Object> getMap();
}