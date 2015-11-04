package org.lukosan.salix;

import org.springframework.http.HttpStatus;

public class SalixHttpException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	
	public SalixHttpException(HttpStatus status) {
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

}
