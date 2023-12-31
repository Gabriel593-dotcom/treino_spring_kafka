package com.treino_kafka.producer.kafkaconfig;

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
    
/*     public KafkaAdmin kafkaAdmin() {
        var config = new HashMap<String, Object>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        return new KafkaAdmin(config);
    }
 */

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
