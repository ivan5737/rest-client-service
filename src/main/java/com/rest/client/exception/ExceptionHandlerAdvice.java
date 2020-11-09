package com.rest.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

  /**
   * Method to handle unexpected exceptions.
   * 
   * @param exception the exception.
   * @return the business exception.
   */
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception exception) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .errorCause(HttpStatus.INTERNAL_SERVER_ERROR).details(exception.getMessage())
        .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).build();
    log.error("type{},code={},message={}", errorResponse.getErrorCause(), errorResponse.getCode(),
        errorResponse.getDetails(), exception);
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(RestClientException.class)
  public final ResponseEntity<Object> handleBookingExceptions(
      RestClientException restClientException) {
    return new ResponseEntity<>(restClientException.getErrorResponse(),
        restClientException.getErrorResponse().getErrorCause());
  }

}
