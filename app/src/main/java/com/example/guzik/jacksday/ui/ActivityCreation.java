package com.example.guzik.jacksday.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.guzik.jacksday.R;

/**
 * Created by guzik on 7/17/17.
 */

public class ActivityCreation extends FragmentActivity {//AppCompatActivity {

    private String activityType;
    private EditText activityDetailsInput;
    private long time = Long.MAX_VALUE;
  //  activityTypeInput

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        //activityTypeInput = findViewById(R.id.radio_group);
        activityDetailsInput = (EditText)findViewById(R.id.details_input);

        Button confirmButton = (Button) findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.w("tagtag", "--->>> JacksActivities confirm... ");

         //       Date actualDate = new Date();
         //       Log.w("tagtag", "--->>> actualDate " + actualDate);

                Log.w("tagtag", "--->>> activityType " + activityType);

                String activityDetails = activityDetailsInput.getText().toString();
                Log.w("tagtag", "--->>> activityDetails " + activityDetails);

                // TODO: create activity with: onRadioButtonClicked, details from text input, time
//                Database database = getIntent().getParcelableExtra("DATA");
//                database.save(new Activity(actualDate, activityType, activityDetails));

                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_TYPE", activityType);
                intent.putExtra("ACTIVITY_DETAILS", activityDetails);
                intent.putExtra("ACTIVITY_TIME", time);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.w("tagtag", "--->>> JacksActivities cancel... ");
                finish();
            }
        });
    }

    public void getRadioButtonState(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_kupa:
                if (checked)
                    activityType = "Kupa";
                    break;
            case R.id.radio_papu:
                if (checked)
                    activityType = "Papu";
                    break;
            default:
                activityType = "Kupa";
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment timePicker = new ActivityTimePicker();
        timePicker.show(getSupportFragmentManager(), "time_picker");
        time = ((ActivityTimePicker) timePicker).getTime();
    }
}
