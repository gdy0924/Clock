package com.example.clock;

import android.os.CountDownTimer;

public class Couterdown extends CountDownTimer {

    public Couterdown(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onFinish() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTick(long arg0) {


    }
    public String  toClock(long millisUntilFinished)

    {
        long hour = millisUntilFinished/(60*60*1000);
        long minute = (millisUntilFinished - hour*60*60*1000)/(60*1000);
        long second = (millisUntilFinished - hour*60*60*1000   - minute*60*1000)/1000;
        if(second >= 60 )
        {
            second = second % 60;
            minute+=second/60;
        }
        if(minute >= 60)
        {
            minute = minute %60;
            hour += minute/60;
        }
        String sh = "";
        String sm ="";
        String ss = "";
        if(hour <10)
        {
            sh = "0" + String.valueOf(hour);
        }else
        {
            sh = String.valueOf(hour);
        }
        if(minute <10)
        {
            sm = "0" + String.valueOf(minute);
        }else
        {
            sm = String.valueOf(minute);
        }
        if(second <10)
        {
            ss = "0" + String.valueOf(second);
        }else
        {
            ss = String.valueOf(second);
        }
        return sh +":"+ sm+":" + ss;
    }

}