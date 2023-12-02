package com.pipeline.config;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class ElasticSearchSinkConnectorConfig extends AbstractConfig {

    public static final String ES_CLUSTER_HOST = "ex.host";
    public ElasticSearchSinkConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
    }
}
