package com.example.guzik.jacksday.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ActivityDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private int year;
    private int month;
    private int day;

    private Calendar activityTimeAndDate;

    public void setCurrentDate(Calendar activityTimeAndDate) {
        this.activityTimeAndDate = activityTimeAndDate;
        this.year = activityTimeAndDate.get(Calendar.YEAR);
        this.month = activityTimeAndDate.get(Calendar.MONTH);
        this.day = activityTimeAndDate.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        activityTimeAndDate.set(Calendar.YEAR, year);
        activityTimeAndDate.set(Calendar.MONTH, month);
        activityTimeAndDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }

    public Calendar getUpdatedDate() { return activityTimeAndDate; }
}
