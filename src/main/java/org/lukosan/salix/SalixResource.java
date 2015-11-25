package org.lukosan.salix;

import java.io.IOException;

public interface SalixResource extends SalixScoped {

	String getSourceId();
	
	String getSourceUri();
	
	String getResourceId();
	
	String getResourceUri();
	
	SalixResourceType getResourceType();
	
	String getContentType();

	void writeTo(ResourceWriter writer) throws IOException;

	boolean exists();
}