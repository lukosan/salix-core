package org.lukosan.salix;

public interface SalixResource extends SalixScoped {

	String getSourceId();
	
	String getSourceUri();
	
	String getResourceId();
	
	String getResourceUri();
	
	SalixResourceType getResourceType();
	
	String getContentType();
}