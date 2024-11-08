package com.task.user.aggregation.config.ds;

import lombok.Data;

@Data
public class DataSourceConfig {
    private String name;
    private DataSourceStrategy strategy;
    private String url;
    private String table;
    private String user;
    private String password;
    private MappingConfig mapping;
}
