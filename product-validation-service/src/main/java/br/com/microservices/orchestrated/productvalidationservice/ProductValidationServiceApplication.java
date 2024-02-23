package br.com.microservices.orchestrated.productvalidationservice;

import io.opentelemetry.api.OpenTelemetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductValidationServiceApplication {

	private final OpenTelemetry openTelemetry;

	public ProductValidationServiceApplication(OpenTelemetry openTelemetry) {
		this.openTelemetry = openTelemetry;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductValidationServiceApplication.class, args);
	}

}
