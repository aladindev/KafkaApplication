package com.example.simple_source_connector;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.types.Password;

import java.util.List;
import java.util.Map;
import java.util.Set;

/** connector 실행 시 받을 설정값들을 정의하는 데에 사용한다. */
public class SingleFileSourceConnectorConfig extends AbstractConfig {

    public static final String DIR_FILE_NAME = "file";
    public static final String DIR_FILE_NAME_DEFAULT_VALUE = "/tmp/kafka.txt";
    private static final String DIR_FILE_NAME_DOC = "읽을 파일 경로와 이름";

    public static final String TOPIC_NAME = "topic";
    private static final String TOPIC_DEFAULT_VALUE = "test";
    private static final String TOPIC_DOC = "보낼 토픽 이름";

    public static ConfigDef CONFIG = new ConfigDef().define(DIR_FILE_NAME
                                    , ConfigDef.Type.STRING
                                    , DIR_FILE_NAME_DEFAULT_VALUE
    , ConfigDef.Importance.HIGH
    , DIR_FILE_NAME_DOC).define(TOPIC_NAME, ConfigDef.Type.STRING,TOPIC_DEFAULT_VALUE, ConfigDef.Importance.HIGH,TOPIC_DOC);



    public SingleFileSourceConnectorConfig(ConfigDef definition, Map<?, ?> originals, Map<String, ?> configProviderProps, boolean doLog) {
        super(definition, originals, configProviderProps, doLog);
    }

    public SingleFileSourceConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
    }

    public SingleFileSourceConnectorConfig(ConfigDef definition, Map<?, ?> originals, boolean doLog) {
        super(definition, originals, doLog);
    }

    @Override
    protected Map<String, Object> postProcessParsedConfig(Map<String, Object> parsedValues) {
        return super.postProcessParsedConfig(parsedValues);
    }

    @Override
    protected Object get(String key) {
        return super.get(key);
    }

    @Override
    public void ignore(String key) {
        super.ignore(key);
    }

    @Override
    public Short getShort(String key) {
        return super.getShort(key);
    }

    @Override
    public Integer getInt(String key) {
        return super.getInt(key);
    }

    @Override
    public Long getLong(String key) {
        return super.getLong(key);
    }

    @Override
    public Double getDouble(String key) {
        return super.getDouble(key);
    }

    @Override
    public List<String> getList(String key) {
        return super.getList(key);
    }

    @Override
    public Boolean getBoolean(String key) {
        return super.getBoolean(key);
    }

    @Override
    public String getString(String key) {
        return super.getString(key);
    }

    @Override
    public ConfigDef.Type typeOf(String key) {
        return super.typeOf(key);
    }

    @Override
    public String documentationOf(String key) {
        return super.documentationOf(key);
    }

    @Override
    public Password getPassword(String key) {
        return super.getPassword(key);
    }

    @Override
    public Class<?> getClass(String key) {
        return super.getClass(key);
    }

    @Override
    public Set<String> unused() {
        return super.unused();
    }

    @Override
    public Map<String, Object> originals() {
        return super.originals();
    }

    @Override
    public Map<String, Object> originals(Map<String, Object> configOverrides) {
        return super.originals(configOverrides);
    }

    @Override
    public Map<String, String> originalsStrings() {
        return super.originalsStrings();
    }

    @Override
    public Map<String, Object> originalsWithPrefix(String prefix) {
        return super.originalsWithPrefix(prefix);
    }

    @Override
    public Map<String, Object> originalsWithPrefix(String prefix, boolean strip) {
        return super.originalsWithPrefix(prefix, strip);
    }

    @Override
    public Map<String, Object> valuesWithPrefixOverride(String prefix) {
        return super.valuesWithPrefixOverride(prefix);
    }

    @Override
    public Map<String, Object> valuesWithPrefixAllOrNothing(String prefix) {
        return super.valuesWithPrefixAllOrNothing(prefix);
    }

    @Override
    public Map<String, ?> values() {
        return super.values();
    }

    @Override
    public Map<String, ?> nonInternalValues() {
        return super.nonInternalValues();
    }

    @Override
    public void logUnused() {
        super.logUnused();
    }

    @Override
    public <T> T getConfiguredInstance(String key, Class<T> t) {
        return super.getConfiguredInstance(key, t);
    }

    @Override
    public <T> T getConfiguredInstance(String key, Class<T> t, Map<String, Object> configOverrides) {
        return super.getConfiguredInstance(key, t, configOverrides);
    }

    @Override
    public <T> List<T> getConfiguredInstances(String key, Class<T> t) {
        return super.getConfiguredInstances(key, t);
    }

    @Override
    public <T> List<T> getConfiguredInstances(String key, Class<T> t, Map<String, Object> configOverrides) {
        return super.getConfiguredInstances(key, t, configOverrides);
    }

    @Override
    public <T> List<T> getConfiguredInstances(List<String> classNames, Class<T> t, Map<String, Object> configOverrides) {
        return super.getConfiguredInstances(classNames, t, configOverrides);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
