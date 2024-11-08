package com.task.user.aggregation.service;

import com.task.user.aggregation.config.ds.DataSourceConfig;
import com.task.user.aggregation.config.ds.DataSourcesConfig;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates the Databases, e.g. when app starts for the first time, to ease the setup.
 */
@Slf4j
@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DatabaseInitializer {

    private DataSourcesConfig dataSourcesConfig;


    @PostConstruct
    public void initialize() {

        for (DataSourceConfig dataSource : dataSourcesConfig.getDataSources()) {
            String url = dataSource.getUrl();
            int queryStringStart = url.lastIndexOf("?");
            int dbNameStart = url.lastIndexOf("/") + 1;
            String databaseName = queryStringStart > -1 ? url.substring(dbNameStart, queryStringStart) : url.substring(dbNameStart);
            String queryString = queryStringStart > -1 ? url.substring(queryStringStart) : "";
            String newConnectionUrl = url.substring(0, dbNameStart) + dataSource.getStrategy().getDefaultDatabase() + queryString;
            try (Connection connection = DriverManager.getConnection(newConnectionUrl, dataSource.getUser(), dataSource.getPassword());
                 Statement statement = connection.createStatement();
            ) {
                statement.executeUpdate("CREATE DATABASE " + databaseName);
                log.info("Created database {} for DataSource: {}", databaseName, dataSource.getStrategy());
            } catch (SQLException e) {
                // just ignore if the DB already exists
            }
        }

    }
}
