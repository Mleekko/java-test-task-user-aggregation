package com.task.user.aggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.task.user.aggregation.config")
public class UserAggregationApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAggregationApplication.class, args);
    }

}
