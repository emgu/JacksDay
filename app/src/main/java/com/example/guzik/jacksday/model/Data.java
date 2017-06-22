package com.example.guzik.jacksday.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private JdbcTemplate jdbcTemplate;

    public Data(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.jdbc.Driver());
        dataSource.setUrl("jdbc:mysql://mn19.webd.pl/krguznic_JacksDay");
        dataSource.setUsername("krguznic_JacksDa");
        dataSource.setPassword("$nufk!n");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Activity> getData(){
        List<Activity> activities = jdbcTemplate.query(sqlSelect, new RowMapper<Activity>() {

            public Activity mapRow(ResultSet result, int rowNum) throws SQLException {
                Activity activity = new Activity();
                activity.setTime(result.getString("action_time"));
                activity.setActivity(result.getString("action_title"));
                activity.setActivityDetail(result.getString("action_detail"));

                return activity;
            }

        });

        return activities;
    }
}
