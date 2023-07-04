package com.treino_kafka.consumer.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface ConsumerCustomListener {
    
    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "msg-topic";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "msgContainerFactory";

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String grouId() default "";
}
