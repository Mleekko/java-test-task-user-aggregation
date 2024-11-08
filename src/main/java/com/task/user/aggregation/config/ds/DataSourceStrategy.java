package com.task.user.aggregation.config.ds;

import lombok.Getter;

@Getter
public enum DataSourceStrategy {
    postgres("postgres"),
    mysql(""),
    ;

    private final String defaultDatabase;

    DataSourceStrategy(String defaultDatabase) {
        this.defaultDatabase = defaultDatabase;
    }

}
