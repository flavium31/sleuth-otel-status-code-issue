package com.example.sleuthotelstatuscodeissue;

import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	public TracerProvider tracerProvider() {
		return SdkTracerProvider.builder()
				.addSpanProcessor(SimpleSpanProcessor.create(new LoggingSpanExporter()))
				.build();
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.alwaysOn();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
