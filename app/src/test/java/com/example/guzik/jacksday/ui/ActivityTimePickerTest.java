package com.example.guzik.jacksday.ui;

import android.support.v4.util.TimeUtils;
import android.test.mock.MockContext;
import android.text.format.DateUtils;
import android.widget.TimePicker;

import com.mysql.jdbc.TimeUtil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ActivityTimePickerTest {

    ActivityTimePicker activityTimePicker = new ActivityTimePicker();

    MockContext mockContext = new MockContext();
    TimePicker view = new TimePicker(mockContext);

    @Test
    public void onTimeSetTest() throws Exception {
        ActivityTimePicker activityTimePicker = new ActivityTimePicker();
        activityTimePicker.onTimeSet(view, 12, 34);
        long exampleTimeInMilis = (12*DateUtils.HOUR_IN_MILLIS) + (34*DateUtils.MINUTE_IN_MILLIS);
        assertEquals(exampleTimeInMilis, activityTimePicker.getTime());
    }
}