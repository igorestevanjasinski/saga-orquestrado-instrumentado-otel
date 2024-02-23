package br.com.microservices.orchestrated.inventoryservice.core.producer;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapSetter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private OpenTelemetry openTelemetry;
    @Value("${spring.kafka.topic.orchestrator}")
    private String orchestratorTopic;


    public void sendEvent(String payload){
        try {
            log.info("Sending event to topic {}, with data {}", orchestratorTopic, payload);
            //var spanContext = Span.fromContext(Context.current()).getSpanContext();
            //openTelemetry.getPropagators().getTextMapPropagator().inject(Context.current(), record);
            kafkaTemplate.send(orchestratorTopic, payload);
        }catch (Exception ex){
            log.error("Error trying to send data to topic {} with data {}", orchestratorTopic, payload, ex);
        }
    }
}
