package com.study.example;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  비동기 처리로 카프카 응답 메세지를 받을 수 있는 클래스
 * */
public class ProducerCallback implements Callback {
    private final static Logger logger = LoggerFactory.getLogger(ProducerCallback.class);

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if(exception != null) {
            logger.error("e.getMessage : " + exception.getMessage(), exception);
        } else {
            logger.info(metadata.toString());
        }
    }
}
