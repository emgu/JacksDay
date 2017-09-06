package com.example.guzik.jacksday.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.guzik.jacksday.R;
import com.example.guzik.jacksday.adapter.Adapter;
import com.example.guzik.jacksday.model.Activity;
import com.example.guzik.jacksday.model.Database;

import java.util.Date;
import java.util.List;

public class JacksActivities extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private final Database database = new Database();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("tagtag", "--->>> JacksActivities starts... ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jacks_activities);
        adapter = new Adapter(this);

//        Log.w("tagtag", "--->>> saving activity...");
//        Date jDate = new Date();
//        database.save(new Activity(jDate, "TITLE", "DETAILS"));
//        Log.w("tagtag", "--->>> activity saved");

        Log.w("tagtag", "--->>> getting activity list...");
        List<Activity> activities = database.getData();
        adapter.setActivities(activities);

        recyclerView = createRecyclerView(adapter);

        Button addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityCreation.class);
                startActivityForResult(intent, 1);
            }
        });

        Button refreshButton = (Button) findViewById(R.id.refresh_button);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        Log.w("tagtag", "--->>> JacksActivities ends... ");
    }

    private RecyclerView createRecyclerView(Adapter adapter){
        recyclerView = (RecyclerView) findViewById(R.id.action_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                database.save(createActivity(intent));
                finish();
                startActivity(getIntent());
            }
        }
    }

    private Activity createActivity(Intent intent) {
        String activityType = intent.getStringExtra("ACTIVITY_TYPE");
        String activityDetails = intent.getStringExtra("ACTIVITY_DETAILS");
        Long activityTime = intent.getLongExtra("ACTIVITY_TIME", new Date().getTime());
        return new Activity(new Date(), activityType, activityDetails);
    }

}
