package com.example.clock;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Timefragment_three extends Fragment {

    TextView tv;
    int a;

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        Bundle b=getArguments();
        a =b.getInt("key");
        System.out.println(a);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.third_fragment_three,container,false);
        return view;
    }

    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv=(TextView)getView().findViewById(R.id.daojishi);
        new Couterdown(a,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText(toClock(millisUntilFinished));
            }
            @Override
            public String toClock(long millis) {
                return super.toClock(millis);
            }
        }.start();

    }
}
