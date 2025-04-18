package com.whastica.microservicioReporte.command.infra.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.whastica.microservicioReporte.command.domain.repository"
)
@EntityScan(basePackages = "com.whastica.microservicioReporte.command.domain.model")
public class JpaConfig {
}