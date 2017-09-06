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

    private long time;
    private int hour;
    private int minute;

    public ActivityTimePicker() {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        c.set(0, 0, 0, hour, minute);
        time = c.getTimeInMillis();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar timeSetByUser = Calendar.getInstance();
        timeSetByUser.set(0, 0, 0, hourOfDay, minute);
        time = timeSetByUser.getTimeInMillis();
        //Log.w("tagtag", ((Long) time).toString());
        System.out.println("--->>> time " + time);
    }

    public long getTime() {
        return time;
    }
}
