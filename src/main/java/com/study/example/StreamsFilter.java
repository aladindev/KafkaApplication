package com.study.example;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

/** 소스 프로세서에서 필터링(스트림 프로세서)를 통해 싱크 프로세서에
 *  필터링 조건에 맞게 걸러 전달하는 스트림 필터 */
public class StreamsFilter {
    private static String APPLICATION_NAME = "stream-application";
    private static String BOOTSTRAP_SERVERS = "my-kafka:9092";
    private static String STREAM_LOG = "stream_log";
    private static String STREAM_LOG_FILTER = "stream_log_filter";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, APPLICATION_NAME);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> streamLog = builder.stream(STREAM_LOG);
        KStream<String, String> filterStream = streamLog.filter(
                (key, value) -> value.length() > 5);

        filterStream.to(STREAM_LOG_FILTER);

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }

}
