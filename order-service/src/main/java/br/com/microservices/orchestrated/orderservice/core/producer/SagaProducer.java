package br.com.microservices.orchestrated.orderservice.core.producer;


import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;

import io.opentelemetry.api.trace.Tracer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.clients.producer.ProducerRecord;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class SagaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private OpenTelemetry openTelemetry;



    @Value("${spring.kafka.topic.start-saga}")
    private String startSagaTopic;


    public void sendEvent(String payload){
        try {
            log.info("Sending event to topic {}, with data {}", startSagaTopic, payload);
            var record = new ProducerRecord<String, String>(startSagaTopic, payload);
            kafkaTemplate.send(record);
        }catch (Exception ex){
            log.error("Error trying to send data to topic {} with data {}", startSagaTopic, payload, ex);
        }

    }


}
