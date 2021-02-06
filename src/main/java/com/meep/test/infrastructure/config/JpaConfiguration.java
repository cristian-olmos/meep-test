package com.meep.test.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.meep.test.infrastructure.repository")
@EntityScan(basePackages = "com.meep.test.domain")
public class JpaConfiguration {
}