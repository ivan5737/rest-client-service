package com.rest.client.feign.deserilizer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public abstract class AbstractDeserilizer<T> extends StdDeserializer<T> {

  private static final long serialVersionUID = -8006719795393238994L;

  public AbstractDeserilizer() {
    this(null);
  }

  protected AbstractDeserilizer(Class<?> vc) {
    super(vc);
  }

  @Override
  public abstract T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException;

  protected String nodeValue(JsonNode node, String nodeName) {
    return node.has(nodeName) ? node.get(nodeName).asText() : "";
  }

  protected Integer nodeValueInt(JsonNode node, String nodeName) {
    return node.has(nodeName) ? node.get(nodeName).asInt() : 0;
  }

}
