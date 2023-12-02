package com.pipeline;

import com.google.gson.Gson;
import com.pipeline.config.ElasticSearchSinkConnectorConfig;
import org.apache.http.HttpHost;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.elasticsearch.action.ActionListener;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class ElasticSearchSinkTask extends SinkTask {

    private final Logger logger = LoggerFactory.getLogger(ElasticSearchSinkTask.class);

    private ElasticSearchSinkConnectorConfig config;
    private RestHighLevelClient esClient;

    @Override
    public void flush(Map<TopicPartition, OffsetAndMetadata> currentOffsets) {
        logger.info("flush");
    }

    @Override
    public void start(Map<String, String> props) {
        try {
            config = new ElasticSearchSinkConnectorConfig(props);
        } catch(ConfigException e) {
            throw new ConnectException(e.getMessage(), e);
        }

        esClient = new RestHighLevelClient(RestClient.builder(new HttpHost(config.getString(config.ES_CLUSTER_HOST),config.getInt(config.ES_CLUSTER_PORT))));
    }

    /** 레코드가 1개 이상, 0개 초과로 들어올 경우 ElasticSearch로 전송하기 위한 BulkRequest 인스턴스
     * BulkRequest는 1개 이상의 데이터들을 묶음으로 엘라스틱서치로 전송할 때 사용된다.
     * BulkRequest에 데이터를 추가할 때는 Map 타입의 데이터와 인덱스 이름이 필요하다.
     * 토픽의 메세지 값은 JSON 형태의 String 타입이므로 */
    @Override
    public void put(Collection<SinkRecord> records) {
        if(records.size() > 0) {
            BulkRequest bulkRequest = new BulkRequest();
            for(SinkRecord record : records) {
                Gson gson = new Gson();
                Map map = gson.fromJson(record.value().toString(), Map.class);
                bulkRequest.add(new IndexRequest(config.getString(config.ES_INDEX)).source(map, XContentType.JSON));
                logger.info("record : {}", record.value());
            }

            esClient.bulkAsync(bulkRequest, RequestOptions.DEFAULT, new ActionListener<BulkResponse>() {
                @Override
                public void onResponse(BulkResponse bulkResponse) {
                    if(bulkResponse.hasFailures()) {
                        logger.error(bulkResponse.buildFailureMessage());
                    } else {
                        logger.info("bulk save success");
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    logger.error(e.getMessage(), e);
                }
            });
        }
    }

    @Override
    public void stop() {
        try {
            esClient.close();
        } catch(IOException e) {
            logger.info(e.getMessage(), e);
        }
    }

    @Override
    public String version() {
        return "1.0";
    }
}
