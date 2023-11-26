package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringKafkaApplication {

    public static Logger logger = LoggerFactory.getLogger(SpringKafkaApplication.class);
    private static String TOPIC_NAME = "test";

    /** KafkaTemplate을 @Autowired 어노테이션으로 주입받아 사용
     * 사용자가 직접 선언하지 않은 bean 객체지만
     * 스프링 카프카에서 제공하는 객체로 주입된다.
     * application.yaml에 선언한 옵션값은 자동으로 주입된다.*/
    @Autowired
    private KafkaTemplate<String, String> customKafkaTemplate;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringKafkaApplication.class);
        application.run(args);
    }

//    /** Kafka Listener */
//    @KafkaListener(topics = "test", groupId = "test-group-00")
//    public void recordListener(ConsumerRecord<String, String> record) {
//        logger.info(record.toString());
//    }
//    @KafkaListener(topics = "test", groupId = "test-group-01")
//    public void singleTopicListener(String messageValue) {
//        logger.info(messageValue);
//    }
//    @KafkaListener(topics = "test", groupId = "test-group-02", properties = {"max.poll.interval.ms:60000", "auto.offset.reset:earliest"})
//    public void singleTopicWithPropertiesListener(String messageValue) {
//        logger.info(messageValue);
//    }
//    @KafkaListener(topicPartitions = {
//             @TopicPartition(topic = "test01", partitions = {"0", "1"})
//            ,@TopicPartition(topic = "test02", partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "3"))
//    })

/* 커맨드 라인으로 실행할 시 */
//    @Override
//    public void run(String... args) throws Exception {
//        ListenableFuture<SendResult<String, String>> future = customKafkaTemplate.send(TOPIC_NAME, "test");
//        future.addCallback(new KafkaSendCallback<String, String>() {
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//
//            }
//            @Override
//            public void onFailure(Throwable ex) {
//                KafkaSendCallback.super.onFailure(ex);
//            }
//            @Override
//            public void onFailure(KafkaProducerException ex) {
//
//            }
//        });
//        System.exit(0); // 작업 완료 후 종료
//    }
}
