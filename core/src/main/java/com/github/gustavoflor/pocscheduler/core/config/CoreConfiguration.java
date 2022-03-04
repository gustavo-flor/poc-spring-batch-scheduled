package com.github.gustavoflor.pocscheduler.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.github.gustavoflor.pocscheduler.core.repository")
@EntityScan(basePackages = "com.github.gustavoflor.pocscheduler.core.entity")
public class CoreConfiguration {
}
