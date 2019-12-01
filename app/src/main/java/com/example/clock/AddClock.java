package com.example.clock;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


import static com.example.clock.AlarmFragment.list;
import static com.example.clock.AlarmFragment.timeAdapter;

public class AddClock extends AppCompatActivity implements View.OnClickListener {
    private Calendar calendar;
    private TextView show_hour;
    private TextView show_minute;
    private EditText content;
    private EditText editText;
    private Button set;
    private Button save;
    private Button choice;
    private ImageView back;
    private TextView title;

    String hourformat;
    String minuteformat;
    Clock clock = new Clock();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String lingsheng = intent.getStringExtra("lingsheng");
        String h=intent.getStringExtra("hours");
        String m=intent.getStringExtra("minutes");
        String flag=intent.getStringExtra("flag");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clock);
        show_hour = findViewById(R.id.hour);
        show_minute = findViewById(R.id.minute);
        content = findViewById(R.id.content);
        editText=findViewById(R.id.lingsheng);
        set = findViewById(R.id.set_time);
        set.setOnClickListener(this);
        save = findViewById(R.id.save);
        choice=findViewById(R.id.xuanzelingsheng);
        choice.setOnClickListener(this);
        back = findViewById(R.id.open_nav);
        back.setImageResource(R.drawable.ic_back);
        back.setOnClickListener(this);
        title = findViewById(R.id.title);
        title.setText("添加闹钟");
        save.setOnClickListener(this);
        calendar = Calendar.getInstance();
    //    lingsheng=findViewById(R.id.lingsheng);


//            show_hour.setText(h);
//            show_minute.setText(m);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_time:
                calendar.setTimeInMillis(System.currentTimeMillis());
                int mhour = calendar.get(Calendar.HOUR_OF_DAY);
                int mminute = calendar.get(Calendar.MINUTE);
                new TimePickerDialog(AddClock.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //calendar.setTimeInMillis(System.currentTimeMillis());
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);


                        hourformat = format(hourOfDay);
                        minuteformat = format(minute);
                        Toast.makeText(AddClock.this, "" + hourformat + ":" + minuteformat, Toast.LENGTH_SHORT).show();
                        show_hour.setText(hourformat);
                        show_minute.setText(minuteformat);


                    }
                }, mhour, mminute, true).show();
                break;
            case R.id.xuanzelingsheng:
                AlertDialog.Builder builder = new AlertDialog.Builder(AddClock.this);
                builder.setTitle("铃声选择" +"");
                //    指定下拉列表的显示数据
                final String[] cities = {"ah", "boom", "millions","mola","zoo"};
                //    设置一个下拉的列表选择项
                builder.setItems(cities, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(AddClock.this, "选择的铃声为：" + cities[which], Toast.LENGTH_SHORT).show();
                        editText.setText(cities[which]);
                    }
                });
                builder.show();
                break;
            case R.id.save:
                Intent intent = new Intent(AddClock.this, CallAlarm.class);
                intent.putExtra("lingsheng",editText.getText().toString());
                System.out.println(editText.getText().toString());
                PendingIntent sender = PendingIntent.getBroadcast(AddClock.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager am;
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if (System.currentTimeMillis()>calendar.getTimeInMillis()+40000){
                        //加24小时
                        am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+86400000, sender);
                    }else {
                        am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
                    }
                }
                clock.setHour(hourformat);
                clock.setMinute(minuteformat);
                clock.setContent("" + content.getText().toString());
                clock.setLingsheng(" "+editText.getText().toString());
                clock.setClockType(Clock.clock_open);
                if (clock.getHour()!="00"&&clock.getMinute()!="00") {
                    clock.save();
                    list.add(clock);
                    timeAdapter.notifyDataSetChanged();
                    Log.e("Listnumber======",list.size()+"");
                    finish();
                }else {
                    Toast.makeText(this, "请选择闹钟时间", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.open_nav:
                finish();
                break;


        }
    }

    private String format(int x) {
        String s = "" + x;
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }
}

