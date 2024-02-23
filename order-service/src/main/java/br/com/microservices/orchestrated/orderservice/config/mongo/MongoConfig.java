package br.com.microservices.orchestrated.orderservice.config.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.mongo.v3_1.MongoTelemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    public String uri;

    private OpenTelemetry openTelemetry;
    @Autowired
    public MongoConfig(OpenTelemetry openTelemetry){
        this.openTelemetry = openTelemetry;
    }

    @Bean
    public MongoClientSettings getSettings() {
        MongoTelemetry mongoTelemetry = MongoTelemetry.builder(openTelemetry).build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .addCommandListener(mongoTelemetry.newCommandListener())
                .build();

        return settings;
    }
}
