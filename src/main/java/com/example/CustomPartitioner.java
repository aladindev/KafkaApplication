package com.example;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.InvalidRecordException;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;

public class CustomPartitioner implements Partitioner {


    @Override
    public void onNewBatch(String topic, Cluster cluster, int prevPartition) {
        Partitioner.super.onNewBatch(topic, cluster, prevPartition);
    }

    // 특정 데이터를 가지는 레코드를 특정 파티션으로 지정해서 보낼 수 있다.
    // 기본 설정 파티셔너를 사용할 경우 메세지 키의 해시값을 파티션에 매칭하여 데이터를 전송하므로
    // 어느 파티션으로 들어가는지 알 수 없다.
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        if(keyBytes == null) throw new InvalidRecordException("Need message KEy");

        if(((String)key).equals("aladin")) {
            return 0;
        }
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        return Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
