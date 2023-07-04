package com.treino_kafka.consumer.listeners;

import org.springframework.stereotype.Component;

import com.treino_kafka.consumer.custom.ConsumerCustomListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ConsumerListener {

    @ConsumerCustomListener(grouId = "group-1")
    public void readMsgTopic(String message) {
        log.info("READED ::: {}", message);
    }
}
