package br.com.microservices.orchestrated.orchestratorservice.config.kafka;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.kafkaclients.v2_6.KafkaTelemetry;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import java.util.Map;

public class OtelProducerFactory extends DefaultKafkaProducerFactory<String, String> {

    private final OpenTelemetry openTelemetry;
    public OtelProducerFactory(Map<String, Object> configs, OpenTelemetry openTelemetry) {
        super(configs);
        this.openTelemetry = openTelemetry;
    }



    @Override
    protected Producer<String, String> createKafkaProducer(){
        final Producer<String, String> producer = super.createKafkaProducer();
        return KafkaTelemetry.create(openTelemetry).wrap(producer);
    }

    @Override
    public Producer<String, String> createProducer(){
        final Producer<String, String> producer = super.createProducer();
        return KafkaTelemetry.create(openTelemetry).wrap(producer);
    }
}

