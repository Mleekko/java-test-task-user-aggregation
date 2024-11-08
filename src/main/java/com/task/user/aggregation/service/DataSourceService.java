package com.task.user.aggregation.service;

import com.task.user.aggregation.config.ds.DataSourceConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DataSourceService {

    public Connection getConnection(DataSourceConfig config) throws SQLException {
        return DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
    }

}
