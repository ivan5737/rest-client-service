package com.rest.client.feign.deserilizer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.rest.client.feign.model.ResponseAlbum;

public class ResponseAlbumDeserilizer extends AbstractDeserilizer<ResponseAlbum> {

  private static final long serialVersionUID = 5983073750900683903L;

  @Override
  public ResponseAlbum deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);
    return ResponseAlbum.builder().no(nodeValueInt(node, "no")).title(nodeValue(node, "title"))
        .music(nodeValue(node, "music")).length(nodeValue(node, "length")).build();
  }

}
