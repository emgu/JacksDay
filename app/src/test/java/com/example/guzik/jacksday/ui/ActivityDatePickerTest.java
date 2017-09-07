package com.example.guzik.jacksday.ui;

import android.test.mock.MockContext;
import android.widget.DatePicker;
import android.widget.TimePicker;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;


public class ActivityDatePickerTest {

    MockContext mockContext = new MockContext();
    DatePicker view = new DatePicker(mockContext);

    @Test
    public void onTimeSetTest() throws Exception {

        final Calendar currentDate = Calendar.getInstance();
        currentDate.set(0,0,0,0,0,0);
        final Calendar userDate = Calendar.getInstance();
        userDate.set(1997,5,22,0,0,0);

        ActivityDatePicker activityDatePicker = new ActivityDatePicker();
        activityDatePicker.setCurrentDate(currentDate);
        activityDatePicker.onDateSet(view, 1997, 5, 22);
        Calendar updatedDate = activityDatePicker.getUpdatedDate();

        assertEquals(userDate.get(Calendar.YEAR), updatedDate.get(Calendar.YEAR));
        assertEquals(userDate.get(Calendar.MONTH), updatedDate.get(Calendar.MONTH));
        assertEquals(userDate.get(Calendar.DAY_OF_MONTH), updatedDate.get(Calendar.DAY_OF_MONTH));
        assertEquals(userDate.get(Calendar.HOUR_OF_DAY), updatedDate.get(Calendar.HOUR_OF_DAY));
        assertEquals(userDate.get(Calendar.HOUR), updatedDate.get(Calendar.HOUR));
        assertEquals(userDate.get(Calendar.MINUTE), updatedDate.get(Calendar.MINUTE));
    }
}