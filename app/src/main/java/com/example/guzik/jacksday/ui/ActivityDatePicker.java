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

    private long date;
    private int year;
    private int month;
    private int day;

    public ActivityDatePicker() {
        Calendar currentDate = Calendar.getInstance();
        year = currentDate.get(Calendar.YEAR);
        month = currentDate.get(Calendar.MONTH);
        day = currentDate.get(Calendar.DAY_OF_MONTH);
        currentDate.set(year, month, day);
        date = currentDate.getTimeInMillis();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar dateSetByUser = Calendar.getInstance();
        dateSetByUser.set(year, month, dayOfMonth);
        date = dateSetByUser.getTimeInMillis();
    }

    public long getDate() { return date; }
}
