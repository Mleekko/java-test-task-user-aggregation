package com.task.user.aggregation.config;

import io.swagger.v3.oas.models.servers.Server;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("task.docs")
public class DocsConfig {
    private List<Server> servers;
}
