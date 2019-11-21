package com.example.clock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Timefragment_three extends Fragment {

    TextView tv;
    ArrayList<Integer> list;

    int a,b,c,total;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.third_fragment_three,container,false);
        return view;
    }

    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv=(TextView)getActivity().findViewById(R.id.daojishi);
        list=getArguments().getIntegerArrayList("key");
        a=list.get(0);
        b=list.get(1);
        c=list.get(2);

        total=a*60*60+b*60+c;
        new Couterdown(30000,1000){
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
