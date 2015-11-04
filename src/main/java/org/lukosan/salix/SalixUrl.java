package org.lukosan.salix;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

public interface SalixUrl extends SalixScoped {
	
	String getUrl();

	HttpStatus getStatus();

	String getView();
	
	LocalDateTime getPublished();
	
	LocalDateTime getRemoved();
	
	Map<String, Object> getMap();
}