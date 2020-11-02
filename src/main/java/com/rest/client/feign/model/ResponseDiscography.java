package com.rest.client.feign.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rest.client.feign.deserilizer.ResponseDiscographyDeserilizer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = ResponseDiscographyDeserilizer.class)
public class ResponseDiscography {

  private String album;

  private String year;

}
