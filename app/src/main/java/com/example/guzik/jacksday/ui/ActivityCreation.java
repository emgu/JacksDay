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

import java.util.Calendar;
import com.example.guzik.jacksday.R;


public class ActivityCreation extends FragmentActivity {//AppCompatActivity {

    private String activityType;
    private EditText activityDetailsInput;
    private Calendar activityTimeAndDate;
    private long timeZero = Long.MIN_VALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        activityDetailsInput = (EditText)findViewById(R.id.details_input);
        activityTimeAndDate = Calendar.getInstance();

        Button confirmButton = (Button) findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_TYPE", activityType);
                intent.putExtra("ACTIVITY_DETAILS", activityDetailsInput.getText().toString());
                intent.putExtra("ACTIVITY_TIME", activityTimeAndDate.getTimeInMillis());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { finish(); }
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
        ((ActivityTimePicker) timePicker).setCurrentTime(activityTimeAndDate);
        timePicker.show(getSupportFragmentManager(), "time_picker");
        activityTimeAndDate = ((ActivityTimePicker) timePicker).getUpdatedTime();
    }

    public void showDatePickerDialog(View v) {
        DialogFragment datePicker = new ActivityDatePicker();
        ((ActivityDatePicker) datePicker).setCurrentDate(activityTimeAndDate);
        datePicker.show(getSupportFragmentManager(), "date_picker");
        activityTimeAndDate = ((ActivityDatePicker) datePicker).getUpdatedDate();
    }
}
