package com.example.clock;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
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

   // private int lastfragment;


    NumberPicker np1;
    NumberPicker np2;
    NumberPicker np3;
    int curhour,curminute,cursecond,a,b,c,total;

  //  CallBackValue callBackValue;


//    @Override	public void onAttach(Activity activity) {
//        // TODO Auto-generated method stub
//        super.onAttach(activity);
//        //当前fragment从activity重写了回调接口  得到接口的实例化对象
//        callBackValue =(CallBackValue) getActivity();
//    }



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.third_fragment,container,false);
        return view;
    }


    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //initFragment();

        np1=(NumberPicker)getView().findViewById(R.id.hournumber) ;
        np2=(NumberPicker)getView().findViewById(R.id.minutenumber) ;
        np3=(NumberPicker)getView().findViewById(R.id.secondnumber) ;

       // init();
        np1.setMaxValue(24);
        np1.setMinValue(0);
        np2.setMaxValue(60);
        np2.setMinValue(0);
        np3.setMaxValue(60);
        np3.setMinValue(0);
        np1.setValue(0);
        np2.setValue(0);
        np3.setValue(0);

        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                curhour = newVal;
                a=newVal;

            }
        });

        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                curminute = newVal;
                b=newVal;
            }
        });

        np3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                cursecond = newVal;
                c=newVal;
            }
        });

        Button bn_start=(Button)getActivity().findViewById(R.id.jishikaishi) ;
        Button bn_reset=(Button)getActivity().findViewById(R.id.jishifuwei) ;

        bn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(lastfragment!=1)
//                {
//                    switchFragment(lastfragment,1);
//                    lastfragment=1;
//                }

//                Intent intent = new Intent(getActivity(),AnotherTimeFragment.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("key", 30000+"");
//                intent.putExtras(bundle);
//                getActivity().startActivity(intent);
  //              callback.getResult(30000+"");

    //            Intent intent=new Intent(getActivity(),AnotherTimeFragment.class);
                //intent.putExtra("time",30000+"");
  //              startActivity(intent);

//                System.out.println(a);
//                System.out.println(curhour);
               // b=np2.getValue();
              //  c=np3.getValue();
                total=(a*60*60+b*60+c)*1000;
                Intent intent=new Intent();
                intent.setClass(getActivity(), AnotherTimeFragment.class);
                Bundle bundle=new Bundle();
                bundle.putString("time",total+"");
                bundle.putString("flag","hhh");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        bn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(lastfragment!=0)
//                {
//                    switchFragment(lastfragment,0);
//                    lastfragment=0;
//                }
                np1.setValue(0);
                np2.setValue(0);
                np3.setValue(0);
            }
        });

    }



}
