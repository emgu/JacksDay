package com.example.guzik.jacksday.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guzik.jacksday.R;
import com.example.guzik.jacksday.adapter.Adapter;
import com.example.guzik.jacksday.model.Activity;
import com.example.guzik.jacksday.model.Data;

import java.util.List;

public class JacksActivities extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jacks_activities);

        System.out.println("JacksActivities starts... ");
        Data data = new Data();
        List<Activity> aa = data.getData();
        System.out.println(aa);
        adapter = new Adapter(aa, this);
        recyclerView = createRecyclerView(adapter);
        System.out.println("JacksActivities ends... ");
    }

    private RecyclerView createRecyclerView(Adapter adapter){
        recyclerView = (RecyclerView) findViewById(R.id.action_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }
}
