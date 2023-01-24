package com.ryan.reward.utils;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class DateFormatter {
    public Date getDateMonthsAgo(int month){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -month);

        Date d = c.getTime();
        return d;
    }
}
