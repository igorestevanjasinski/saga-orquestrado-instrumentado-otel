package br.com.microservices.orchestrated.orderservice;

import io.opentelemetry.api.OpenTelemetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	private final OpenTelemetry openTelemetry;

	public OrderServiceApplication(OpenTelemetry openTelemetry) {
		this.openTelemetry = openTelemetry;
	}

	public static void main(String[] args) {

		SpringApplication.run(OrderServiceApplication.class, args);
	}
}
