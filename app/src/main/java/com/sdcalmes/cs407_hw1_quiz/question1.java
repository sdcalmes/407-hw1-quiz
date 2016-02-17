package com.sdcalmes.cs407_hw1_quiz;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class question1 extends android.app.Fragment {

    private Button mGoToQ2;
    public question1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_question1, container, false);
        mGoToQ2 = (Button)view.findViewById(R.id.nextQ);

        mGoToQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class fragmentClass;
                android.app.Fragment fragment = null;
                fragmentClass = question2.class;
                try {
                    fragment = (android.app.Fragment) fragmentClass.newInstance();
                } catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragManager = getFragmentManager();
                getFragmentManager().beginTransaction().replace(R.id.fragment_holder, fragment).commit();
            }
        });

        return view;


    }

}
