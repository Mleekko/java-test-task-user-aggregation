package com.task.user.aggregation.spring;

import com.task.user.aggregation.config.DocsConfig;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration {

    @Bean
    public OpenAPI customOpenAPI(DocsConfig config) {
        return new OpenAPI()
                .info(new Info()
                        .title("User Aggregation Service API Definition")
                        .version("0.0.1")
                        .description("A service for aggregating users data from multiple databases.")
                        .license(null)
                )
                .servers(config.getServers());
    }

}
