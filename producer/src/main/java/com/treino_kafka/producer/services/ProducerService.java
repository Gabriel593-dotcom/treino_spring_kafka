package com.treino_kafka.producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProducerService {

  public final KafkaTemplate<String, String> KafkaTemplate;

  public void sendMessage(String message) {
    KafkaTemplate
      .send("msg-topic", message)
      .addCallback(
        success -> {
          if (success != null) {
            log.info(
              "success in send message to kafka topic {}",
              message + " - topic ::: {}",
              success.getRecordMetadata().partition()
            );
          }
        },
        error -> log.error("error in send message to kafka topic {}", message)
      );
  }
}
