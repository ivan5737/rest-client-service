package com.rest.client.mocks;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import com.opentable.extension.BodyTransformer;

@Configuration
public class MockConfig {

  @Value("${com.rest.client.mocks.server.port}")
  private Integer port;

  @Value("${com.rest.client.mocks.rootDirectory}")
  private String rootDirectory;

  @Bean
  WireMockServer wireMockServer() {
    WireMockServer wireMockServer =
        new WireMockServer(options().port(port).withRootDirectory(rootDirectory)
            .notifier(new Slf4jNotifier(true)).extensions(new BodyTransformer()));
    wireMockServer.start();
    return wireMockServer;
  }

}
