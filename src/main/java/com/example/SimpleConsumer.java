package com.example;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.*;

public class SimpleConsumer {
    private final static Logger logger = LoggerFactory.getLogger(SimpleProducer.class);
    private final static String TOPIC_NAME = "test"; // 전송하고자 하는 토픽명
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";
    private final static String GROUP_ID = "test-group";

    public static void main(String[] args) {
        Properties configs = new Properties();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);

        /* 프로듀서가 브로커에 데이터를 전달할 때의 직렬화 타입에 맞춰서 역직렬화를 해야함 */
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        /* 동기 offset commit */
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configs);

        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        consumer.subscribe(Arrays.asList(TOPIC_NAME));

        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

            for(ConsumerRecord<String, String> record : records) {
                logger.info("{}", record);

                //개별 레코드 단위로 매번 오프셋 커밋
//                Map<TopicPartition, OffsetAndMetadata> currentOffset = new HashMap<>();
//                currentOffset.put(new TopicPartition(record.topic(), record.partition())
//                                , new OffsetAndMetadata(record.offset()+1, null));

                //sync offset commit
                //consumer.commitSync();

                // 개별 레코드 단위 매번 옵셋 커밋
                //consumer.commitSync(currentOffset);

                // Async offset commit : 커밋이 완료될 때까지
                // 응답을 기다리지 않기 때문에 동기 옵셋 커밋보다 동일 시간당 데이터 처리량이 더 많다.
                //consumer.commitAsync();

                // callback 함수를 파라미터로 받아서 결과를 얻을 수 있다.
                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {
                        if(exception != null) System.err.println("Commit Failed");
                        else System.out.println("Commit Succeeded");

                        if(exception != null) logger.error("Commit failed for offsets {}", offsets, exception);
                    }
                });


            }
        }
    }

    // 컨슈머 내에 리밸런스가 일어났을 때 응답 주는 클래스
    private static class RebalanceListener implements ConsumerRebalanceListener {

        @Override
        public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
            logger.warn("Partitions are revoked");
        }

        @Override
        public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
            logger.warn("Partitions are assigned");

        }

        @Override
        public void onPartitionsLost(Collection<TopicPartition> partitions) {
            ConsumerRebalanceListener.super.onPartitionsLost(partitions);
        }
    }
}


