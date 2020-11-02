package com.rest.client.feign.rest;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.client.feign.model.RequestAlbum;
import com.rest.client.feign.model.ResponseAlbum;
import com.rest.client.feign.model.ResponseDiscography;
import com.rest.client.feign.service.ClienService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/metallica")
@RequiredArgsConstructor
public class FeignClientController {

  private final ClienService clienService;

  @GetMapping(value = "/discography", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<ResponseDiscography> discography() {
    return clienService.discography();
  }
  
  @PostMapping(value = "/album", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<ResponseAlbum> album(@RequestBody RequestAlbum requestAlbum) {
    return clienService.album(requestAlbum);
  }

}
