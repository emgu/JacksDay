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
    private long time = 0L;
    private long date = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        //activityTypeInput = findViewById(R.id.radio_group);
        activityDetailsInput = (EditText)findViewById(R.id.details_input);

        Button confirmButton = (Button) findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_TYPE", activityType);
                intent.putExtra("ACTIVITY_DETAILS", activityDetailsInput.getText().toString());
                intent.putExtra("ACTIVITY_TIME", calculateTime());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { finish(); }
        });
    }

    private long calculateTime() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        if(time == 0L && date == 0L) {
            return c.getTimeInMillis();
        }
        if(time == 0L && date != 0L){
            c.set(0, 0, 0, hour, minute);
            return date + c.getTimeInMillis();
        }
        if(time != 0L && date == 0L){
            c.set(year, month, day, 0, 0);
            return c.getTimeInMillis() + time;
        }
        return time + date;
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

    public void showDatePickerDialog(View v) {
        DialogFragment datePicker = new ActivityDatePicker();
        datePicker.show(getSupportFragmentManager(), "date_picker");
        date = ((ActivityDatePicker) datePicker).getDate();
    }
}
