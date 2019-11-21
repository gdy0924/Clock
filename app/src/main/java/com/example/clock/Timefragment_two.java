package com.example.clock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Timefragment_two extends Fragment {


    private int lastfragment;



    Timefragment_one f1=new Timefragment_one();
    Timefragment_three f3=new Timefragment_three();

    private Fragment[] fs;

    public Timefragment_two() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.third_fragment_two,container,false);
        return view;
    }


    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragment();





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
