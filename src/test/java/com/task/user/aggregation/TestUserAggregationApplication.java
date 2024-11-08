package com.task.user.aggregation;

import org.springframework.boot.SpringApplication;

public class TestUserAggregationApplication {

    public static void main(String[] args) {
        SpringApplication.from(UserAggregationApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
