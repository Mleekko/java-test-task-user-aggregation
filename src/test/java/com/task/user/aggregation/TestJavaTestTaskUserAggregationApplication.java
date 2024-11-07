package com.task.user.aggregation;

import org.springframework.boot.SpringApplication;

public class TestJavaTestTaskUserAggregationApplication {

    public static void main(String[] args) {
        SpringApplication.from(JavaTestTaskUserAggregationApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
