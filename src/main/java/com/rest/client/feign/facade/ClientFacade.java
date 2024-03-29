/*
 * Copyright (C) 2016 by Citigroup. All rights reserved. Citigroup claims copyright in this computer
 * program as an unpublished work, one or more versions of which were first used to provide services
 * to customers on the dates indicated in the foregoing notice. Claim of copyright does not imply
 * waiver of other rights.
 *
 * NOTICE OF PROPRIETARY RIGHTS
 *
 * This program is a confidential trade secret and the property of Citigroup. Use, examination,
 * reproduction, disassembly, decompiling, transfer and/or disclosure to others of all or any part
 * of this software program are strictly prohibited except by express written agreement with
 * Citigroup.
 */

package com.rest.client.feign.facade;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rest.client.feign.model.RequestAlbum;
import com.rest.client.feign.model.ResponseAlbum;
import com.rest.client.feign.model.ResponseDiscography;

@FeignClient(name = "metallica", url = "${com.rest.host}")
public interface ClientFacade {

  @RequestMapping(value = "${com.rest.endpoint.discography}")
  List<ResponseDiscography> discography();

  @RequestMapping(value = "${com.rest.endpoint.album}")
  List<ResponseAlbum> album(RequestAlbum requestAlbum);

}
