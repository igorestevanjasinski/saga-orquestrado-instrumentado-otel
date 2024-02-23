package br.com.microservices.orchestrated.orchestratorservice;

import io.opentelemetry.api.OpenTelemetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrchestratorServiceApplication {

	private final OpenTelemetry openTelemetry;

	public OrchestratorServiceApplication(OpenTelemetry openTelemetry) {
		this.openTelemetry = openTelemetry;
	}

	public static void main(String[] args) {

		SpringApplication.run(OrchestratorServiceApplication.class, args);
	}

}
