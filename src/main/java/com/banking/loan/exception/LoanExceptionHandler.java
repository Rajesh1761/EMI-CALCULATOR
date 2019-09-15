package com.banking.loan.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class LoanExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ApiException.class })
    public ResponseEntity<Object> handleApiException(ApiException apiException, WebRequest webRequest) {
        logger.error("API Exception: {} "+apiException.getErrorMessage(), apiException);
        final ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(apiException.getErrorMessage());
        return handleExceptionInternal(apiException, apiExceptionResponse, new HttpHeaders(),
                apiException.getHttpStatus(), webRequest);
    }
}