package com.example.clock;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

public class AlarmAlert extends Activity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent intent=getIntent();

        Bundle bundle = intent.getExtras();

        String lingsheng=bundle.getString("lingsheng2");
        System.out.println(lingsheng);
        super.onCreate(savedInstanceState);
        int position = getIntent().getIntExtra("position",-1);
        if(lingsheng.equals("ah")){
            mediaPlayer = MediaPlayer.create(this,R.raw.ah);
        }else if(lingsheng.equals("boom")){
            mediaPlayer = MediaPlayer.create(this,R.raw.boom);
        }else if(lingsheng.equals("millions")){
            mediaPlayer = MediaPlayer.create(this,R.raw.millions);
        }else if(lingsheng.equals("mola")){
            mediaPlayer = MediaPlayer.create(this,R.raw.mola);
        }else if(lingsheng.equals("zoo")){
            mediaPlayer = MediaPlayer.create(this,R.raw.zoo);
        }
        mediaPlayer.start();
        new AlertDialog.Builder(AlarmAlert.this)
                .setIcon(R.drawable.newnaozhong)
                .setTitle("闹钟响了")
                .setCancelable(false)
                .setMessage("时间到了！")
                .setPositiveButton("关掉"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlarmAlert.this.finish();
                                mediaPlayer.stop();
                            }
                        }).show();
    }
}

