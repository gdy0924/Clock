package com.example.clock;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatchFragment extends Fragment {


    int second;

    private ListView list;
    ListAdapter adapter;




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
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
//        initView();
//        setListener();
        final Chronometer ch = (Chronometer) getActivity().findViewById(R.id.jishi);
        Button bn_start=(Button)getActivity().findViewById(R.id.start);
        Button bn_jici=(Button)getActivity().findViewById(R.id.jici);
        Button bn_pause=(Button)getActivity().findViewById(R.id.pause);
        Button bn_reset=(Button)getActivity().findViewById(R.id.reset);
        list = (ListView)getActivity().findViewById(R.id.timelist);


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
                final String s=ch.getText().toString();

                final String[] filename = {s};


                    adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, filename);

                    list.setAdapter(adapter);

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
