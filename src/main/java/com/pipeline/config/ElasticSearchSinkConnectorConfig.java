package com.pipeline.config;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class ElasticSearchSinkConnectorConfig extends AbstractConfig {

    public static final String ES_CLUSTER_HOST = "ex.host";
    private static final String ES_CLUSTER_HOST_DEFAULT_VALUE = "localhost";
    private static final String ES_CLUSTER_HOST_DOC = "엘라스틱서치 호스트를 입력";

    public static final String ES_CLUSTER_PORT = "es.port";
    private static final String ES_CLUSTER_PORT_DEFAULT_VALUE = "9200";
    private static final String ES_CLUSTER_PORT_DOC = "엘라스틱서치 포트를 입력";

    public static final String ES_INDEX = "ex.index";
    private static final String ES_INDEX_DEFAULT_VALUE = "kafka-connector-index";
    private static final String ES_INDEX_DOC = "엘라스틱서치 인덱스를 입력";

    

    public ElasticSearchSinkConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
    }
}
