package com.example.clock;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatchFragment extends Fragment {


    int second;

    public StopWatchFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fourth_fragment,container,false);
        return view;
    }
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Chronometer ch = (Chronometer) getActivity().findViewById(R.id.jishi);
        Button bn_start=(Button)getActivity().findViewById(R.id.start);
        Button bn_jici=(Button)getActivity().findViewById(R.id.jici);
        Button bn_pause=(Button)getActivity().findViewById(R.id.pause);
        Button bn_reset=(Button)getActivity().findViewById(R.id.reset);


        bn_pause.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                ch.stop();

                ch.setText(FormatMiss(second));

            }

        });

        bn_start.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                ch.start();

            }

        });

        bn_reset.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                ch.stop();

                second = 0;

                ch.setText(FormatMiss(second));

            }

        });

        bn_jici.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {


            }

        });

        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {



            @Override

            public void onChronometerTick(Chronometer chronometer) {

                second++;

                chronometer.setText(FormatMiss(second));

            }

        });
    }


    //格式转换为HH:MM:SS

    public static String FormatMiss(int second) {

        if (second == 0) {

            return "00:00:00";

        }

        String hh = second / 3600 > 9 ? second / 3600 + "" : "0" + second / 3600;

        String mm = (second % 3600) / 60 > 9 ? (second % 3600) / 60 + "" : "0" + (second % 3600) / 60;

        String ss = (second % 3600) % 60 > 9 ? (second % 3600) % 60 + "" : "0" + (second % 3600) % 60;

        return hh + ":" + mm + ":" + ss;

    }

}
