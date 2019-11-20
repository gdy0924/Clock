package com.example.clock;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatchFragment extends Fragment {


    public StopWatchFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.first_fragment,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        textView=(TextView)getActivity().findViewById(R.id.textView1);
//        button=(Button)getActivity().findViewById(R.id.button1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override            public void onClick(View view) {
//                Toast.makeText(getActivity(),"Fragment1",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}
