package com.rest.client.exception;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse implements Serializable {

  private static final long serialVersionUID = 6663671283850148325L;

  private String code;

  private String details;

  private HttpStatus errorCause;

  @Builder.Default
  private String uuid = new StringBuilder().append(UUID.randomUUID()).append("-")
      .append(System.currentTimeMillis()).toString();

  @Builder.Default
  private String timestamp = Instant.now().toString();
}
