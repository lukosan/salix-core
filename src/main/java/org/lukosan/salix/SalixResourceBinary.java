package org.lukosan.salix;

public interface SalixResourceBinary extends SalixResource {

	byte[] getBytes();
	
	default SalixResourceType getResourceType() {
		return SalixResourceType.BINARY;
	}

}
