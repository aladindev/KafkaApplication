package com.study.example;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.apache.kafka.connect.source.SourceTaskContext;

import java.util.List;
import java.util.Map;

public class TestSourceTask extends SourceTask {
    public TestSourceTask() {
        super();
    }

    /** 태스크가 시작할 때 필요한 로직을 작성한다.
     * 태스크는 실질적으로 데이터를 처리하는 역할을 하므로
     * 데이터 처리에 필요한 모든 소스를 여기서 초기화하면 좋다.
     * 예를 들어, JDBC 소스 커넥터를 구현한다면 이 메소드에서 JDBC 커넥션을 맺는다.*/
    @Override
    public void start(Map<String, String> props) {

    }

    /** Source Application 혹은 Source File로부터
     * 데이터를 읽어오는 로직을 작성한다.
     * 데이터를 읽어오면 토픽으로 보낼 데이터를 SourceRecord로 정의한다.
     * SourceRecord 클래스는 토픽으로 데이터를 정의하기 위해 사용한다.
     * List<SourceRecord> 인스턴스에 데이터를 담아 리턴하면
     * 데이터가 토픽으로 전송된다.*/
    @Override
    public List<SourceRecord> poll() throws InterruptedException {
        return null;
    }

    @Override
    public void initialize(SourceTaskContext context) {
        super.initialize(context);
    }

    @Override
    public void commit() throws InterruptedException {
        super.commit();
    }

    @Override
    public void commitRecord(SourceRecord record) throws InterruptedException {
        super.commitRecord(record);
    }

    @Override
    public void commitRecord(SourceRecord record, RecordMetadata metadata) throws InterruptedException {
        super.commitRecord(record, metadata);
    }

    @Override
    public void stop() {

    }

    @Override
    public String version() {
        return null;
    }
}
