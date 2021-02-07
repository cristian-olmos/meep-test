package com.meep.test.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {
        "com.meep.test.infrastructure.repository",
        "com.meep.test.shared.infrastructure.repository",
})
public class JpaConfiguration {
}