package com.rest.client.restemplate.dto;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestClientDto {

  private final RestTemplate restTemplate;

  public <T> T getForObject(URI uri, Class<T> responseType, HttpHeaders headers) {
    HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
    return restTemplate.exchange(uri, HttpMethod.GET, requestEntity, responseType).getBody();
  }

  public <T> T getForObject(URI uri, Class<T> responseType) {
    return restTemplate.getForObject(uri, responseType);
  }

  public <T> T postForObject(URI uri, Class<T> responseType, Object request, HttpHeaders headers) {
    HttpEntity<Object> requestEntity = new HttpEntity<>(request, headers);
    return restTemplate.postForObject(uri, requestEntity, responseType);
  }

  public <T> T postForObject(URI uri, Class<T> responseType, Object request) {
    return restTemplate.postForObject(uri, request, responseType);
  }

}
