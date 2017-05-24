package com.example.guzik.jacksday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guzik.jacksday.R;
import com.example.guzik.jacksday.model.Activity;

import java.util.List;

/**
 * Created by guzik on 5/21/17.
 */

public class Adapter extends RecyclerView.Adapter<ActivityViewHolder> {

    private List<Activity> activities;
    private LayoutInflater layoutInflater;

    public Adapter(List<Activity> activities, Context context){
        this.activities = activities;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity, parent, false);
        return new ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActivityViewHolder holder, int position) {
        Activity activity = activities.get(position);
        holder.setActivityTime(activity.getTime());
        holder.setActivityTitle(activity.getTitle());
        //holder.setActivityDetail TODO
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }
}
