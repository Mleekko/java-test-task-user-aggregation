package com.task.user.aggregation.service;

import com.task.user.aggregation.config.ds.DataSourceConfig;
import com.task.user.aggregation.config.ds.DataSourcesConfig;
import com.task.user.aggregation.config.ds.MappingConfig;
import com.task.user.aggregation.dto.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private DataSourcesConfig dataSourcesConfig;
    private DataSourceService dataSourceService;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (DataSourceConfig dataSource : dataSourcesConfig.getDataSources()) {
            MappingConfig mapping = dataSource.getMapping();
            try (Connection connection = dataSourceService.getConnection(dataSource);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(createQuery(dataSource))
            ) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getString(mapping.getId()));
                    user.setUsername(resultSet.getString(mapping.getUsername()));
                    user.setName(resultSet.getString(mapping.getName()));
                    user.setSurname(resultSet.getString(mapping.getSurname()));
                    users.add(user);
                }
            } catch (SQLException e) {
                // just ignore the failing DS.
                log.error("Failed to query DS " + dataSource.getName(), e);
            }
        }

        return users;
    }

    private String createQuery(DataSourceConfig dataSource) {
        return "SELECT " + getFields(dataSource.getMapping()) + " FROM " + dataSource.getTable();
    }

    private String getFields(MappingConfig mapping) {
        return StringUtils.joinWith(", ", mapping.getId(), mapping.getUsername(), mapping.getName(), mapping.getSurname());
    }

}
