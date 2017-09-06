package com.example.guzik.jacksday.ui;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ActivityTimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private int hour;
    private int minute;

    private Calendar activityTimeAndDate;

    public void setCurrentTime(Calendar activityTimeAndDate) {
        this.activityTimeAndDate = activityTimeAndDate;
        this.hour = activityTimeAndDate.get(Calendar.HOUR_OF_DAY);
        this.minute = activityTimeAndDate.get(Calendar.MINUTE);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        activityTimeAndDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
        activityTimeAndDate.set(Calendar.MINUTE, minute);
    }

    public Calendar getUpdatedTime() {
        return activityTimeAndDate;
    }
}
