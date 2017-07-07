package com.example.guzik.jacksday.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityRowMapper implements RowMapper{
    @Override
    public Activity mapRow(ResultSet result, int rowNum) throws SQLException {
        Activity activity = new Activity();
        activity.setTime(result.getString("action_time"));
        activity.setActivity(result.getString("action_title"));
        activity.setActivityDetail(result.getString("action_detail"));
        return activity;
    }
}
