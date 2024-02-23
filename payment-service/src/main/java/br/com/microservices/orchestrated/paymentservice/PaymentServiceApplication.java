package br.com.microservices.orchestrated.paymentservice;

import io.opentelemetry.api.OpenTelemetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentServiceApplication {

	private final OpenTelemetry openTelemetry;

	public PaymentServiceApplication(OpenTelemetry openTelemetry) {
		this.openTelemetry = openTelemetry;
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
