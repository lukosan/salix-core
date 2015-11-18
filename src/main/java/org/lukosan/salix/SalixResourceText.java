package org.lukosan.salix;

public interface SalixResourceText {

	String getText();
	
	default SalixResourceType getResourceType() {
		return SalixResourceType.TEXT;
	}

}
