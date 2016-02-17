package com.sdcalmes.cs407_hw1_quiz;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    private question1 q1Frag;
    private question2 q2Frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button beginQuiz = (Button)findViewById(R.id.button);

        beginQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginQuiz.setVisibility(View.GONE);
                Class fragmentClass;
                Fragment fragment = null;
                fragmentClass = question1.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragManager = getFragmentManager();
                getFragmentManager().beginTransaction().replace(R.id.fragment_holder, fragment).commit();

            }
        });

    }
}
