package com.example.guzik.jacksday.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.guzik.jacksday.R;

/**
 * Created by guzik on 5/22/17.
 */

public class ActivityViewHolder extends RecyclerView.ViewHolder {

    private TextView activityTime;
    private TextView activityTitle;
    private TextView activityDetails; //TODO
    private View container;

    public ActivityViewHolder(View itemView) {
        super(itemView);
        activityTime = (TextView)itemView.findViewById(R.id.action_time);
        activityTitle = (TextView)itemView.findViewById(R.id.action_title);
        container = itemView.findViewById(R.id.action_item);
    }

    public TextView getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime.setText(activityTime);
    }

    public TextView getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle.setText(activityTitle);
    }

    public TextView getActivityDetails() {
        return activityDetails;
    }

    public void setActivityDetails(String activityDetails) {
        this.activityDetails.setText(activityDetails);
    }

    public View getContainer() {
        return container;
    }

    public void setContainer(View container) {
        this.container = container;
    }
}
