package com.example.guzik.jacksday.model;

import android.util.Log;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by guzik on 5/21/17.
 */

public class Activity {

    private Date dateAndTime;
    private String name;
    private String details;
    //TODO icon?

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public Activity(){};

    public Activity(Date dateAndTime, String name, String details){
        this.dateAndTime = dateAndTime;
        this.name = name;
        this.details = details;
        Log.w("tagtag", "--->>> Activity constructor " + this);
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(long time) {
        this.dateAndTime = new Date(time);
    }

    public String getDate() {
        return dateFormat.format(dateAndTime);
    }

    public String getTime() {
        return timeFormat.format(dateAndTime);
    }

    public long getTimeInMilisec() {
        return dateAndTime.getTime();
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