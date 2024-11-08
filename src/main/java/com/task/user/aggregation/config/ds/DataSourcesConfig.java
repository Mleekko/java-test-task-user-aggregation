package com.task.user.aggregation.config.ds;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@Data
@SuppressWarnings("ConfigurationProperties")
@ConfigurationProperties
public class DataSourcesConfig {

    private List<DataSourceConfig> dataSources;


}
