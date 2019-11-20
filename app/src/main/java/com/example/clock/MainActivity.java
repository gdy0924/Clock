package com.example.clock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Bundle;

import android.util.Log;



import android.os.Bundle;

import android.os.SystemClock;

import android.app.Activity;

import android.view.MenuItem;
import android.view.View;

import android.widget.Button;

import android.widget.Chronometer;

import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.TextClock;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    ClockFragment clockFragment = new ClockFragment();
    AlarmFragment alarmFragment = new AlarmFragment();
    TimerFragment timerFragment = new TimerFragment();
    StopWatchFragment stopWatchFragment = new StopWatchFragment();

    private BottomNavigationView bottomNavigationView;

    private Fragment[] fragments;

    private int lastfragment;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initFragment();
        //获取计时器组件

     //   final Chronometer ch = (Chronometer)findViewById(R.id.test);

//        TextClock mTextClock = (TextClock)findViewById(R.id.textclock);
//        // 设置12时制显示格式
//        mTextClock.setFormat12Hour("EEEE, MMMM dd, yyyy h:mmaa");
//        // 设置24时制显示格式
//        mTextClock.setFormat24Hour("yyyy-MM-dd hh:mm, EEEE");



        //获取开始按钮

//        Button start =(Button)findViewById(R.id.ok);
//
//        start.setOnClickListener(new View.OnClickListener()
//
//        {
//
//            @Override
//
//            public void onClick(View source)
//
//            {
//
//                //设置开始时间
//
//                ch.setBase(SystemClock.elapsedRealtime());
//
//                //启动计时器
//
//                ch.start();
//
//            }
//
//        });
//
//        ch.setOnChronometerTickListener(new OnChronometerTickListener()
//
//        {
//
//            public void OnChronometerTick(Chronometer ch)
//
//            {
//
//                if(SystemClock.elapsedRealtime() - ch.getBase() > 20*1000)
//
//                {
//
//                    ch.stop();
//
//                }
//
//            }
//
//            @Override
//
//            public void onChronometerTick(Chronometer arg0) {
//
//                // TODO Auto-generated method stub
//
//            }
//
//        });
//
  }
    private void initFragment()    {
         clockFragment = new ClockFragment();
         alarmFragment = new AlarmFragment();
         timerFragment = new TimerFragment();
         stopWatchFragment = new StopWatchFragment();
        fragments = new Fragment[]{clockFragment,alarmFragment,timerFragment,stopWatchFragment};
        lastfragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview,clockFragment).show(clockFragment).commit();
        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener()
    {        @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())            {
            case R.id.clock:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;
                    }
                    return true;
                }
                case R.id.alarm:
                    {
                        if(lastfragment!=1)
                        {
                            switchFragment(lastfragment,1);
                            lastfragment=1;
                        }
                        return true;
                    }
                    case R.id.timer:
                        {
                            if(lastfragment!=2)
                            {
                                switchFragment(lastfragment,2);
                                lastfragment=2;
                            }
                            return true;
                        }
            case R.id.stopWatch:
            {
                if(lastfragment!=3)
                {
                    switchFragment(lastfragment,3);
                    lastfragment=3;
                }
                return true;
            }
        }
        return false;
    }
    };
    private void switchFragment(int lastfragment,int index)    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
         if(fragments[index].isAdded()==false)        {
             transaction.add(R.id.mainview,fragments[index]);
         }
         transaction.show(fragments[index]).commitAllowingStateLoss();
    }



}
