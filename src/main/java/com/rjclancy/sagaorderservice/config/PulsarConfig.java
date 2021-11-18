package com.rjclancy.sagaorderservice.config;

import org.apache.pulsar.client.api.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PulsarConfig {

  private static final String SERVICE_URL = "pulsar://localhost:6650";
  private static final String ORDER_CONSUMER_TOPIC_NAME = "orderConsumerTopicName";
  private static final String ORDER_CONSUMER_SUBSCRIPTION_NAME = "orderConsumerSubscriptionName";
  private static final String ORDER_EVENT_TOPIC_NAME = "orderEventTopicName";

  @Bean
  public PulsarClient pulsarClient() throws PulsarClientException {
    return PulsarClient.builder()
        .serviceUrl(SERVICE_URL)
        .build();
  }

  @Bean
  public Consumer<byte[]> orderConsumer(final PulsarClient pulsarClient) throws PulsarClientException {
    return pulsarClient.newConsumer()
        .topic(ORDER_CONSUMER_TOPIC_NAME)
        .subscriptionType(SubscriptionType.Shared)
        .subscriptionName(ORDER_CONSUMER_SUBSCRIPTION_NAME)
        .subscribe();
  }

  @Bean
  public Producer<byte[]> orderEventProducer(final PulsarClient pulsarClient) throws PulsarClientException {
    return pulsarClient.newProducer()
        .topic(ORDER_EVENT_TOPIC_NAME)
        .compressionType(CompressionType.LZ4)
        .create();
  }
}
