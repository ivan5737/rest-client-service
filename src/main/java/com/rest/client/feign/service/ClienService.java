package com.rest.client.feign.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.rest.client.feign.facade.ClientFacade;
import com.rest.client.feign.model.RequestAlbum;
import com.rest.client.feign.model.ResponseAlbum;
import com.rest.client.feign.model.ResponseDiscography;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienService {

  private final ClientFacade clientFacade;

  public List<ResponseDiscography> discography() {
    return clientFacade.discography();
  }

  public List<ResponseAlbum> album(RequestAlbum requestAlbum) {
    return clientFacade.album(requestAlbum);
  }
}
