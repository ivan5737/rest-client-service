package com.rest.client.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;

public class RestClientException extends RuntimeException {

  private static final long serialVersionUID = -7295039836060212290L;

  @Getter
  private final ErrorResponse errorResponse;

  public RestClientException(String message) {
    super(message);
    this.errorResponse = ErrorResponse.builder().errorCause(HttpStatus.INTERNAL_SERVER_ERROR)
        .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).details(message).build();
  }

}
