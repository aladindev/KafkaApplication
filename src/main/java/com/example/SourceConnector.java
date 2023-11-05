package com.example;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.ConnectorTransactionBoundaries;
import org.apache.kafka.connect.source.ExactlyOnceSupport;
import org.apache.kafka.connect.source.SourceConnectorContext;

import java.util.List;
import java.util.Map;

public class SourceConnector extends org.apache.kafka.connect.source.SourceConnector {
    public SourceConnector() {
        super();
    }

    @Override
    protected SourceConnectorContext context() {
        return super.context();
    }

    @Override
    public void start(Map<String, String> props) {

    }

    @Override
    public Class<? extends Task> taskClass() {
        return null;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        return null;
    }

    @Override
    public void stop() {

    }

    @Override
    public ConfigDef config() {
        return null;
    }

    @Override
    public ExactlyOnceSupport exactlyOnceSupport(Map<String, String> connectorConfig) {
        return super.exactlyOnceSupport(connectorConfig);
    }

    @Override
    public ConnectorTransactionBoundaries canDefineTransactionBoundaries(Map<String, String> connectorConfig) {
        return super.canDefineTransactionBoundaries(connectorConfig);
    }

    @Override
    public boolean alterOffsets(Map<String, String> connectorConfig, Map<Map<String, ?>, Map<String, ?>> offsets) {
        return super.alterOffsets(connectorConfig, offsets);
    }

    @Override
    public String version() {
        return null;
    }
}
