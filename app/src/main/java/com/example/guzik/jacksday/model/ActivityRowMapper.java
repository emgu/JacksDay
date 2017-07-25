package com.example.guzik.jacksday.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityRowMapper implements RowMapper{
    @Override
    public Activity mapRow(ResultSet result, int rowNum) throws SQLException {
        Activity activity = new Activity();
        activity.setDateAndTime(result.getLong("time"));
        activity.setName(result.getString("type"));
        activity.setDetails(result.getString("details"));
        return activity;
    }
}
