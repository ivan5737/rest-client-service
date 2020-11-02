package com.rest.client.restemplate.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.client.restemplate.model.RequestAlbum;
import com.rest.client.restemplate.model.ResponseAlbum;
import com.rest.client.restemplate.model.ResponseDiscography;
import com.rest.client.restemplate.service.RestClientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/metallicaRest")
@RequiredArgsConstructor
public class RestClientController {

  private final RestClientService clienService;

  @GetMapping(value = "/discography", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseDiscography[] discography() {
    return clienService.discography();
  }

  @PostMapping(value = "/album", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseAlbum[] album(@RequestBody RequestAlbum requestAlbum) {
    return clienService.album(requestAlbum);
  }

}
