package com.whastica.microservicioReporte.query.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
    basePackages = "com.whastica.microservicioReporte.query.domain.repository"
)
public class MongoConfig {
}