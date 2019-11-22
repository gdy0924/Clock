package com.example.clock;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class Timefragment_one extends Fragment {

    NumberPicker np1,np2,np3;

    ArrayList<Integer> list;

    //Button bn;

    int curhour,curminute,cursecond,total;
    public Timefragment_one() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.third_fragment_one,container,false);
        return view;
    }


    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        np1 = (NumberPicker) getView().findViewById(R.id.hournumber);
        np2 = (NumberPicker) getView().findViewById(R.id.minutenumber);
        np3 = (NumberPicker) getView().findViewById(R.id.secondnumber);
        np1.setMaxValue(24);
        np1.setMinValue(0);
        np2.setMaxValue(60);
        np2.setMinValue(0);
        np3.setMaxValue(60);
        np3.setMinValue(0);
        curhour = 0;
        curminute = 0;
        cursecond = 0;
        np1.setValue(curhour);
        np2.setValue(curminute);
        np3.setValue(cursecond);

        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                curhour = newVal;
            }
        });

        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                curminute = newVal;
            }
        });

        np3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                cursecond = newVal;
            }
        });
    }

}
