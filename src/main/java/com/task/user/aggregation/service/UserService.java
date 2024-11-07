package com.task.user.aggregation.service;

import com.task.user.aggregation.config.DataSourcesConfig;
import com.task.user.aggregation.dto.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private DataSourcesConfig dataSourcesConfig;

    public List<User> getUsers() {
        System.out.println(dataSourcesConfig);
        return Collections.emptyList();
    }

}
