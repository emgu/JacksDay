package com.example.guzik.jacksday.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Data {

    private static final String URL = "jdbc:mysql://mn19.webd.pl/krguznic_JacksDay";
    private static final String USERNAME = "krguznic_JacksDa";
    private static final String PASSWORD = "$nufk!n";

    private JdbcTemplate jdbcTemplate;

    public Data(){
        SimpleDriverDataSource dataSource = createDatasource();
        if(null != dataSource) {
            jdbcTemplate = new JdbcTemplate();
        }
    }

    private SimpleDriverDataSource createDatasource() {
        try {
            return new SimpleDriverDataSource(new com.mysql.jdbc.Driver(), URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Activity> getData(){
        String sqlSelect = "SELECT * FROM activities";
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
