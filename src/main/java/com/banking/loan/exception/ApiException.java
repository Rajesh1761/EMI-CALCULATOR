package com.banking.loan.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4402471769056257240L;
	private String errorMessage;
    private HttpStatus httpStatus;
    
    public ApiException(){
    	
    }

    public ApiException(final String errorMessage, final HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    String getErrorMessage() {
        return errorMessage;
    }

    HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
