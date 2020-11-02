package com.rest.client.feign.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rest.client.feign.deserilizer.ResponseAlbumDeserilizer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = ResponseAlbumDeserilizer.class)
public class ResponseAlbum {

  private Integer no;

  private String title;

  private String music;

  private String length;

}
