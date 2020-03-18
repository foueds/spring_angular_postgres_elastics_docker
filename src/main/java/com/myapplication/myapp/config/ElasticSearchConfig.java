package com.myapplication.myapp.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.myapplication.myapp.repository.es")
@ComponentScan(basePackages = { "com.myapplication.myapp.service.es" })
public class ElasticSearchConfig {

  private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

  @Value("${elasticsearch.cluster-name}")
  private String clusterName;

  @Value("${elasticsearch.host}")
  private String host;

  @Value("${elasticsearch.port}")
  private int port;

  @Bean
  public Client client() {
    TransportClient client = null;
    try {
      final Settings elasticsearchSettings = Settings.builder()
        .put("client.transport.sniff", true)
        .put("cluster.name", clusterName).build();
      client = new PreBuiltTransportClient(elasticsearchSettings);
      client.addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
      client.listedNodes();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    return client;
  }

  @Bean
  public ElasticsearchOperations elasticsearchTemplate() {
    return new ElasticsearchTemplate(client());
  }
}

