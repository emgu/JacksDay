package com.example.guzik.jacksday.ui;

import android.provider.Settings;
import android.support.v4.util.TimeUtils;
import android.test.mock.MockContext;
import android.text.format.DateUtils;
import android.widget.TimePicker;

import com.mysql.jdbc.TimeUtil;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ActivityTimePickerTest {

    MockContext mockContext = new MockContext();
    TimePicker view = new TimePicker(mockContext);

    @Test
    public void onTimeSetTest() throws Exception {

        final Calendar currentTime = Calendar.getInstance();
        currentTime.set(2017,0,10,0,0,0);
        final Calendar userTime = Calendar.getInstance();
        userTime.set(2017,0,10,12,34,0);

        ActivityTimePicker activityTimePicker = new ActivityTimePicker();
        activityTimePicker.setCurrentTime(currentTime);
        activityTimePicker.onTimeSet(view, 12, 34);
        Calendar updatedTime = activityTimePicker.getUpdatedTime();

        assertEquals(userTime.get(Calendar.YEAR), updatedTime.get(Calendar.YEAR));
        assertEquals(userTime.get(Calendar.MONTH), updatedTime.get(Calendar.MONTH));
        assertEquals(userTime.get(Calendar.DAY_OF_MONTH), updatedTime.get(Calendar.DAY_OF_MONTH));
        assertEquals(userTime.get(Calendar.HOUR_OF_DAY), updatedTime.get(Calendar.HOUR_OF_DAY));
        assertEquals(userTime.get(Calendar.HOUR), updatedTime.get(Calendar.HOUR));
        assertEquals(userTime.get(Calendar.MINUTE), updatedTime.get(Calendar.MINUTE));
    }
}