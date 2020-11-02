package com.rest.client.restemplate.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
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

  private final RestClientDto restClientDto;

  public ResponseDiscography[] discography() {
    try {
      return restClientDto.discographyDto(getHeaders());
    } catch (Exception ex) {
      log.error("Error: ", ex);
      throw new RestClientException(ex.getMessage());
    }
  }

  public ResponseAlbum[] album(RequestAlbum requestAlbum) {
    try {
      return restClientDto.albumDto(requestAlbum, getHeaders());
    } catch (Exception ex) {
      log.error("Error: ", ex);
      throw new RestClientException(ex.getMessage());
    }
  }

  private HttpHeaders getHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", "application/json; charset=UTF-8");
    return headers;
  }

}
