package com.rest.client.restemplate.dto;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.rest.client.restemplate.model.RequestAlbum;
import com.rest.client.restemplate.model.ResponseAlbum;
import com.rest.client.restemplate.model.ResponseDiscography;
import com.rest.client.restemplate.util.Mapper;

@Repository
public class RestClientDto {

  @Value("${com.rest.host}${com.rest.endpoint.discography}")
  private String hostDiscography;

  @Value("${com.rest.host}${com.rest.endpoint.album}")
  private String hostAlbum;

  public ResponseDiscography[] discographyDto(HttpHeaders httpHeaders) throws URISyntaxException {
    RequestEntity<String> requestEntity =
        new RequestEntity<>(null, httpHeaders, HttpMethod.GET, new URI(hostDiscography));
    ResponseEntity<ResponseDiscography[]> response =
        new RestTemplate().exchange(requestEntity, ResponseDiscography[].class);
    return response.getBody();
  }

  public ResponseAlbum[] albumDto(RequestAlbum requestAlbum, HttpHeaders httpHeaders)
      throws IOException, URISyntaxException {
    RequestEntity<String> requestEntity = new RequestEntity<>(
        Mapper.writeValueAsString(requestAlbum), httpHeaders, HttpMethod.POST, new URI(hostAlbum));
    ResponseEntity<ResponseAlbum[]> response =
        new RestTemplate().exchange(requestEntity, ResponseAlbum[].class);
    return response.getBody();
  }

}
