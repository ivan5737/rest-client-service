package com.rest.client.restemplate.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class Mapper {

  private Mapper() {}

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static <T> T readValue(String body, Class<T> clazz) throws IOException {
    return OBJECT_MAPPER.readValue(body, clazz);
  }

  public static <T> String writeValueAsString(T request) throws JsonProcessingException {
    return OBJECT_MAPPER.writeValueAsString(request);
  }



}
