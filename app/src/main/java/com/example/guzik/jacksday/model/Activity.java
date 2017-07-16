package com.example.guzik.jacksday.model;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by guzik on 5/21/17.
 */

public class Activity {

    private String date;
    private String time;
    private String name;
    private String details;
    //TODO icon?

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public Activity(){};

    public Activity(Date dateAndTime, String name, String details){
        this.date = dateFormat.format(dateAndTime);
        this.time = timeFormat.format(dateAndTime);
        this.name = name;
        this.details = details;
        Log.w("tagtag", "--->>> Activity constructor " + this);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Object getIcon() {
        return "icon";
    }
}