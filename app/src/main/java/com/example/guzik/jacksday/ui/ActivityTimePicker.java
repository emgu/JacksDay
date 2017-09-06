package com.example.guzik.jacksday.ui;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.concurrent.TimeUnit;

public class ActivityTimePicker extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private long time = Long.MAX_VALUE;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int hour = Integer.MAX_VALUE;
        int minute = Integer.MAX_VALUE;

        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        time = TimeUnit.HOURS.toMillis(hourOfDay) + TimeUnit.MINUTES.toMillis(minute);
    }

    public long getTime() {
        return time;
    }
}
