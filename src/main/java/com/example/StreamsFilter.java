package com.example;

/** 소스 프로세서에서 필터링(스트림 프로세서)를 통해 싱크 프로세서에
 *  필터링 조건에 맞게 걸러 전달하는 스트림 필터 */
public class StreamsFilter {
    private static String APPLICATION_NAME = "stream-application";
    private static String BOOTSTRAP_SERVERS = "my-kafka:9092";
    private static String STREAM_LOG = "stream_log";
    private static String STREAM_LOG_FILTER = "stream_log_filter";
}
