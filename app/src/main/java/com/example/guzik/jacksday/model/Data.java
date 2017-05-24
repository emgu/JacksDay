package com.example.guzik.jacksday.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guzik on 5/21/17.
 */

public class Data {

    static final Activity[] sampleActivities = {
            new Activity("02:33", "jedzenie", "50ml mlenia"),
            new Activity("3:33", "spanie", "30min"),
            new Activity("4:34", "spanie", "50min"),
            new Activity("8:33", "jedzenie", "150ml mlenia"),
            new Activity("12:03", "spanie", "30min"),
            new Activity("15:33", "spanko", "1,5h"),
            new Activity("20:33", "jedzenie", "10ml mlenia"),
            new Activity("22:33", "jedzenie", "80ml mlenia")
    };

    public static List<Activity>getData(){
        ArrayList<Activity> activities = new ArrayList<>();
        for(int i = 0; i < sampleActivities.length; i++){
            activities.add(sampleActivities[i]);
        }
        return activities;
    }
}
