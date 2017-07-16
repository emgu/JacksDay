package com.example.guzik.jacksday.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.guzik.jacksday.R;

/**
 * Created by guzik on 5/22/17.
 */

public class ActivityViewHolder extends RecyclerView.ViewHolder {

    private TextView date;
    private TextView time;
    private TextView name;
    private TextView details;
    private View container;

    public ActivityViewHolder(View itemView) {
        super(itemView);
        date = (TextView)itemView.findViewById(R.id.date);
        time = (TextView)itemView.findViewById(R.id.time);
        name = (TextView)itemView.findViewById(R.id.name);
        details = (TextView)itemView.findViewById(R.id.details);
        container = itemView.findViewById(R.id.activity);
    }

    public TextView getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public TextView getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time.setText(time);
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details.setText(details);
    }

    public View getContainer() {
        return container;
    }

    public void setContainer(View container) {
        this.container = container;
    }
}
