package com.example.demo;

import com.google.cloud.opentelemetry.trace.TraceConfiguration;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceConfiguration;
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqlCommenterDemoApplication {

  public static void main(String[] args) throws IOException {
    setupOpenCensus();
    setupOpenTelemetry();

    SpringApplication.run(SqlCommenterDemoApplication.class, args);
  }

  private static void setupOpenCensus() throws IOException {
    StackdriverTraceExporter.createAndRegister(
        StackdriverTraceConfiguration.builder().setProjectId("cloud-debugging").build());
  }

  private static void setupOpenTelemetry() throws IOException {
    TraceConfiguration configuration =
        TraceConfiguration.builder().setProjectId("cloud-debugging").build();

    TraceExporter traceExporter = TraceExporter.createWithConfiguration(configuration);

    // Register the TraceExporter with OpenTelemetry
    OpenTelemetrySdk.getGlobalTracerManagement()
        .addSpanProcessor(BatchSpanProcessor.builder(traceExporter).build());
  }
}
