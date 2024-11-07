package com.task.user.aggregation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@Data
@SuppressWarnings("ConfigurationProperties")
@ConfigurationProperties
public class DataSourcesConfig {

    private List<DataSourceConfig> dataSources;


    @Data
    public static class DataSourceConfig {
        private String name;
        private String strategy;
        private String url;
        private String table;
        private String user;
        private String password;
        private MappingConfig mapping;
    }

    @Data
    public static class MappingConfig {
        private String id;
        private String username;
        private String name;
        private String surname;
    }

}
