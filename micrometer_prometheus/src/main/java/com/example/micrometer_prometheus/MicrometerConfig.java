package com.example.micrometer_prometheus;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfig {
    @Bean
    public MeterRegistryCustomizer prometheusMeterRegistry(MeterRegistry meterRegistry) {
        return meterRegistry1 -> {
            meterRegistry.config().commonTags("application" , "micrometer-prometheus example");
        };
    }
}
