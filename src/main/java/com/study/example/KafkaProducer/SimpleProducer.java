package com.study.example.KafkaProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProducer {
    private final static Logger logger = LoggerFactory.getLogger(SimpleProducer.class);
    private final static String TOPIC_NAME = "test"; // 전송하고자 하는 토픽명
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";

    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 특정 파티션을 지정할 때 커스텀파티셔너 클래스를 인자로 전달
        configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class);

        KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

        String messageValue = "testMessage";
        RecordMetadata metadata = null;
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, "aladin", "28");
        //metadata = producer.send(record).get();
        producer.send(record, new ProducerCallback());

        producer.flush();
        producer.close();

    }*/
}
