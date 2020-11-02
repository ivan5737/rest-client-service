package com.rest.client.feign.deserilizer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.rest.client.feign.model.ResponseDiscography;

public class ResponseDiscographyDeserilizer extends AbstractDeserilizer<ResponseDiscography> {

  private static final long serialVersionUID = -7498947918002070353L;

  @Override
  public ResponseDiscography deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);
    return ResponseDiscography.builder().album(nodeValue(node, "album"))
        .year(nodeValue(node, "year")).build();
  }

}
