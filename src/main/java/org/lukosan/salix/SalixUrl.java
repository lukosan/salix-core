package org.lukosan.salix;

import java.time.LocalDateTime;
import java.util.Map;

public interface SalixUrl extends SalixScoped {
	
	String getUrl();

	int getStatus();

	String getView();
	
	LocalDateTime getPublished();
	
	LocalDateTime getRemoved();
	
	Map<String, Object> getMap();
}