package com.example.clock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AnotherTimeFragment extends AppCompatActivity {

    Button bn_zanting;
    Button bn_fuwei;
    TextView daojishi;

//    Intent intent = getIntent();
//    String position = intent.getStringExtra("key");
//    int a=Integer.parseInt(position);
//    Intent intent=getIntent();
//    String time=intent.getStringExtra("time");
//    int a=Integer.parseInt(time);

//    Intent intent=getIntent();
//
//    Bundle bundle = intent.getExtras();
//
//    String name=bundle.getString("time");
//    int a=Integer.parseInt(name);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_fragment_three);

        bn_zanting=(Button)findViewById(R.id.zantingjishi);
        bn_fuwei=(Button)findViewById(R.id.jishifuwei);
        daojishi=(TextView)findViewById(R.id.daojishi);

        new Couterdown(30000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                daojishi.setText(toClock(millisUntilFinished));
            }
            @Override
            public String toClock(long millis) {
                return super.toClock(millis);
            }
        }.start();

        bn_fuwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnotherTimeFragment.this,TimerFragment.class);
                startActivity(intent);

            }
        });
    }


}
