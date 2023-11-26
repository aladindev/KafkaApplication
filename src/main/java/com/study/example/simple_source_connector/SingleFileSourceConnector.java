package com.study.example.simple_source_connector;


import org.apache.kafka.common.config.Config;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.connector.ConnectorContext;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.source.SourceConnector;

import java.util.List;
import java.util.Map;

public class SingleFileSourceConnector extends SourceConnector {

    private Map<String, String> configProperties;

    public SingleFileSourceConnector() {
        super();
    }

    @Override
    public ConfigDef config() {
        return null;
    }

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public void start(Map<String, String> props) {
        this.configProperties = props;
        try {
            //new SingleFileSourceConnectorConfig(props);
        } catch(ConfigException e) {
            throw new ConnectException(e.getMessage(), e);
        }
    }

    @Override
    public void initialize(ConnectorContext ctx) {
        super.initialize(ctx);
    }

    @Override
    public void initialize(ConnectorContext ctx, List<Map<String, String>> taskConfigs) {
        super.initialize(ctx, taskConfigs);
    }

    @Override
    public void reconfigure(Map<String, String> props) {
        super.reconfigure(props);
    }

    @Override
    public Config validate(Map<String, String> connectorConfigs) {
        return super.validate(connectorConfigs);
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

}
