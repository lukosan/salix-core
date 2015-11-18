package org.lukosan.salix;

import java.util.Map;

public interface SalixResourceJson extends SalixResource {

	Map<String, Object> getMap();
	
	default String getContentType() {
		return "application/json";
	}
	default SalixResourceType getResourceType() {
		return SalixResourceType.JSON;
	}

}
