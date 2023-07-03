package com.treino_kafka.producer.kafkaconfig;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class KafkaAdminConfig {
    public final KafkaProperties properties;
    
    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
            TopicBuilder
            .name("msg-topic")
            .partitions(2)
            .replicas(1)
            .build()
        );
    }
}
