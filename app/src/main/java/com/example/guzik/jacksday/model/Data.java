package com.example.guzik.jacksday.model;

import android.os.StrictMode;
import android.util.Log;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final String URL = "jdbc:mysql://mn19.webd.pl/krguznic_JacksDay";
    private static final String USERNAME = "krguznic_JacksDa";
    private static final String PASSWORD = "$nufk!n";

    private JdbcTemplate jdbcTemplate;

    public Data(){
        Log.w("tagtag", "--->>> Data class constructor");
        SimpleDriverDataSource dataSource = createDatasource();
        if(null != dataSource) {
            jdbcTemplate = new JdbcTemplate(dataSource);
            Log.w("tagtag", "--->>> dataSource");
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
        List<Activity> activities = new ArrayList<>();
        if(setThreadPolicy()) {
            String sqlSelect = "SELECT * FROM activity";
            Log.w("tagtag", "--->>> sqlSelect" + sqlSelect);
            activities = jdbcTemplate.query(sqlSelect, new ActivityRowMapper());
        }
        Log.w("tagtag", "--->>> activities" + activities);
        return activities;
    }

    public void save(Activity activity){
        if(setThreadPolicy()) {
            String sqlInsert = "INSERT INTO activity "
                    + "(`date`, `time`, `name`, `details`, `icon`)"
                    + " VALUES (?, ?, ?, ?, ?)";

            jdbcTemplate.update(sqlInsert,
                    activity.getDate(),
                    activity.getTime(),
                    activity.getName(),
                    activity.getDetails(),
                    activity.getIcon());
        }
    }
    private boolean setThreadPolicy() {
        if (android.os.Build.VERSION.SDK_INT > 8) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            return true;
        }
        return false;
    }
}
