package com.example.KafkaProcessor;

import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;

public class FilterProcessor implements Processor {

    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
    }

    @Override
    public void close() {
        Processor.super.close();
    }

    @Override
    public void process(Record record) {
        if(record.value().toString().length() > 5) {
            context.forward(record, record.value().toString());
        }
        context.commit();
    }
}
