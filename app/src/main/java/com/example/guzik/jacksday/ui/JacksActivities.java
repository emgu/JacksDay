package com.example.guzik.jacksday.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.guzik.jacksday.R;
import com.example.guzik.jacksday.adapter.Adapter;
import com.example.guzik.jacksday.model.Activity;
import com.example.guzik.jacksday.model.Data;

import java.util.Date;

public class JacksActivities extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jacks_activities);
        Log.w("tagtag", "--->>> JacksActivities starts... ");
        Data data = new Data();

        Log.w("tagtag", "--->>> saving activity...");
        Date jDate = new Date();
        data.save(new Activity(jDate, "TITLE", "DETAILS"));
        Log.w("tagtag", "--->>> activity saved");

        Log.w("tagtag", "--->>> getting activity list...");
        adapter = new Adapter(data.getData(), this);
        recyclerView = createRecyclerView(adapter);
        
        Log.w("tagtag", "--->>> JacksActivities ends... ");
    }

    private RecyclerView createRecyclerView(Adapter adapter){
        recyclerView = (RecyclerView) findViewById(R.id.action_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }
}
