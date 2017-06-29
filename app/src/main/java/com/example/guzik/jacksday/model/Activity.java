package com.example.guzik.jacksday.model;

/**
 * Created by guzik on 5/21/17.
 */

public class Activity {

    private String time;
    private String title;
    private String activityDetail;
    //TODO icon?
    public Activity(){};

    public Activity(String time, String title, String activityDetail){
        this.time = time;
        this.title = title;
        this.activityDetail = activityDetail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setActivity(String activity) {
        this.title = activity;
    }

    public String getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
    }

}