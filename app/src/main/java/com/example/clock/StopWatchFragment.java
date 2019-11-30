package com.example.clock;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.litepal.crud.DataSupport;

import static com.example.clock.StopWatchFragment.list;
import static com.example.clock.StopWatchFragment.adapter;


import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatchFragment extends Fragment {


    public static List<String> list = new ArrayList<>();
    public static ListView listView;
    int second;

    public static ArrayAdapter adapter;






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

    private void initJiShiView() {


        adapter = adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adapter);
        list.clear();

        adapter.notifyDataSetChanged();
    }
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);



        final Chronometer ch = (Chronometer) getActivity().findViewById(R.id.jishi);

        final Button bn_start=(Button)getActivity().findViewById(R.id.start);
        Button bn_jici=(Button)getActivity().findViewById(R.id.jici);
        Button bn_reset=(Button)getActivity().findViewById(R.id.reset);
        listView = (ListView)getActivity().findViewById(R.id.timelist);

        LitePal.getDatabase();
       initJiShiView();


        bn_start.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(bn_start.getText().equals("开始")){
                    ch.start();
                    bn_start.setText("暂停");
                }else{
                    ch.stop();

                    ch.setText(FormatMiss(second));
                    bn_start.setText("开始");
                }


            }

        });

        bn_reset.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                ch.stop();

                second = 0;

                ch.setText(FormatMiss(second));
                list.clear();
                adapter.notifyDataSetChanged();
            }

        });

        bn_jici.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

               final String s=ch.getText().toString();

                list.add(s);
                adapter.notifyDataSetChanged();

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
