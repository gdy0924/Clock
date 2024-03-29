package com.example.clock;

import org.litepal.crud.DataSupport;

public class Clock extends DataSupport {
    public static final int clock_open = 1;
    public static final int clock_close = 0;

    String hour;
    String minute;
    String content;
    String lingsheng;
    int  ClockType;

    public String getLingsheng() {
        return lingsheng;
    }

    public void setLingsheng(String lingsheng) {
        this.lingsheng = lingsheng;
    }

    public String getMinute() {
        return minute;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public int getClockType() {
        return ClockType;
    }

    public void setClockType(int clockType) {
        ClockType = clockType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
