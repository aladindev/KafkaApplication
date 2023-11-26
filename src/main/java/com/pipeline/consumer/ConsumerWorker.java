package com.pipeline.consumer;

import org.apache.hadoop.conf.Configuration;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.TopicPartition;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConsumerWorker implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(ConsumerWorker.class);
    private static Map<Integer, List<String>> bufferString = new ConcurrentHashMap<>();
    private static Map<Integer, Long> currentFileOffset = new ConcurrentHashMap<>();

    private final static int FLUSH_RECORD_COUNT = 10;
    private Properties prop;
    private String topic;
    private String threadName;
    private KafkaConsumer<String, String> consumer;

    public ConsumerWorker(Properties prop, String topic, int number) {
        logger.info("Generate ConsumerWorker");
        this.prop = prop;
        this.topic = topic;
        this.threadName = "consumer-thread-" + number;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(threadName);
        consumer = new KafkaConsumer<>(prop);
        consumer.subscribe(Arrays.asList(topic));
        try {
            while(true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

                for(ConsumerRecord<String, String> record = records) {
                    addHdfsFileBuffer(record);
                }
                saveBufferToHdfsFile(Consumer.assignment());
            }
        } catch(WakeupException e) {
            logger.warn("Wakeup consumer");
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            consumer.close();
        }
    }

    private void addHdfsFileBuffer(ConsumerRecord<String, String> record) {
        List<String> buffer = bufferString.getOrDefault(record.partition(), new ArrayList<>());
        buffer.add(record.value());
        bufferString.put(record.partition(), buffer);

        if(buffer.size() == 1) {
            currentFileOffset.put(record.partition(), record.offset());
        }
    }

    private void saveBufferToHdfsFile(Set<TopicPartition> partitions) {
        partitions.forEach(p -> checkFlushCount(p.partition));
    }

    private void checkFlushCount(int partitionNo) {
        if(bufferString.get(partitionNo) != null) {
            if(bufferString.get(partitionNo).size() > FLUSH_RECORD_COUNT - 1) {
                save(partitionNo);
            }
        }
    }

    private void save(int partitionNo) {
        if(bufferString.get(partitionNo).size() > 0) {
            try {
                String fileName = "/data/color-" + partitionNo + "-"
                        + currentFileOffset.get(partitionNo) + ".log";
                Configuration configuration = new Configuration();
            }
        }
    }
}
