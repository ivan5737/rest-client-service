package com.rest.client.restemplate.service;

import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import com.rest.client.constants.Constants;
import com.rest.client.exception.RestClientException;
import com.rest.client.restemplate.dto.RestClientDto;
import com.rest.client.restemplate.model.RequestAlbum;
import com.rest.client.restemplate.model.ResponseAlbum;
import com.rest.client.restemplate.model.ResponseDiscography;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestClientService {

  @Value("${com.rest.host}${com.rest.endpoint.discography}")
  private String hostDiscography;

  @Value("${com.rest.host}${com.rest.endpoint.album}")
  private String hostAlbum;

  private final RestClientDto restClientDto;

  public ResponseDiscography[] discography() {
    try {
      URI uri = buildUri(hostDiscography);
      return restClientDto.getForObject(uri, ResponseDiscography[].class, getHeaders());
    } catch (Exception ex) {
      log.error(Constants.ERROR, ex);
      throw new RestClientException(ex.getMessage());
    }
  }

  public ResponseAlbum[] album(RequestAlbum requestAlbum) {
    try {
      URI uri = buildUri(hostAlbum);
      return restClientDto.postForObject(uri, ResponseAlbum[].class, requestAlbum, getHeaders());
    } catch (Exception ex) {
      log.error(Constants.ERROR, ex);
      throw new RestClientException(ex.getMessage());
    }
  }

  private URI buildUri(String httpUrl) {
    return UriComponentsBuilder.fromHttpUrl(httpUrl).build().toUri();
  }

  private HttpHeaders getHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", "application/json; charset=UTF-8");
    return headers;
  }

}
