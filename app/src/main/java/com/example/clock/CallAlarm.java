package com.example.clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class CallAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String lingsheng=intent.getStringExtra("lingsheng");
        System.out.println(lingsheng);


        Intent intent1 = new Intent(context,AlarmAlert.class);
        Bundle bundle = new Bundle();
       // String content = intent.getStringExtra("content");
       // System.out.println(content);

        //Log.e("content===sadsad",content);
        bundle.putString("STR_CALLER","");
       bundle.putString("lingsheng2",lingsheng);
        intent1.putExtras(bundle);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
