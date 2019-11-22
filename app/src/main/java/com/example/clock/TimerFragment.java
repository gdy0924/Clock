package com.example.clock;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimerFragment extends Fragment {

    public TimerFragment() {
        // Required empty public constructor
    }

    private int lastfragment;


    NumberPicker n1;
    NumberPicker n2;
    NumberPicker n3;

    Timefragment_one f1=new Timefragment_one();
    Timefragment_two f2=new Timefragment_two();
    Timefragment_three f3=new Timefragment_three();

    int a;

    private Fragment[] fs;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.third_fragment,container,false);
        return view;
    }


    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragment();

        n1=(NumberPicker)getView().findViewById(R.id.hournumber) ;
        n2=(NumberPicker)getView().findViewById(R.id.minutenumber) ;
        n3=(NumberPicker)getView().findViewById(R.id.secondnumber) ;

         final EditText text=(EditText)getView().findViewById(R.id.text) ;
        Button bn_start=(Button)getActivity().findViewById(R.id.jishikaishi) ;
        Button bn_reset=(Button)getActivity().findViewById(R.id.jishifuwei) ;

        bn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastfragment!=1)
                {
                    switchFragment(lastfragment,1);
                    lastfragment=1;
                }

            }
        });

        bn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastfragment!=0)
                {
                    switchFragment(lastfragment,0);
                    lastfragment=0;
                }
            }
        });

    }
    private void initFragment(){
        fs = new Fragment[]{f1,f3};
        lastfragment=0;
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.timer_one,f1).show(f1).commit();
    }


    private void switchFragment(int lastfragment,int index)    {
        FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
        transaction.hide(fs[lastfragment]);//隐藏上个Fragment
        if(fs[index].isAdded()==false)        {
            transaction.add(R.id.mainview,fs[index]);
        }
        transaction.show(fs[index]).commitAllowingStateLoss();
    }

}
