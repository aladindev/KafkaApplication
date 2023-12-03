package com.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class RestApiProducer {

    @Autowired
    private KafkaTemplate<String, String> customKafkaTemplate;
    public static void main(String[] args) {
        SpringApplication.run(RestApiProducer.class, args);

    }
}
