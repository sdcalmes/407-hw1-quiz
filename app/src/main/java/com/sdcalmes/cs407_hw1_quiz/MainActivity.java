package com.sdcalmes.cs407_hw1_quiz;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private question1 q1Frag;
    private question2 q2Frag;
    Button beginQuiz;
    String ans1;
    String ans2;
    String out;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView3);
        beginQuiz = (Button)findViewById(R.id.button);
        FragmentManager fragManager = getFragmentManager();

        beginQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginQuiz.setVisibility(View.INVISIBLE);
                tv.setText("");
                Class fragmentClass;
                Fragment fragment = null;
                fragmentClass = question1.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e){
                    e.printStackTrace();
                }

                getFragmentManager().beginTransaction().replace(R.id.fragment_holder, fragment).commit();

            }
        });

    }

    public void getAns1Data(String data){
        ans1 = data;
        System.out.println("Ans1: " + ans1);
    }

    public void getAns2Data(String data){
        ans2 = data;
        beginQuiz.setVisibility(View.VISIBLE);

        System.out.println("Ans2: " + ans2);
        checkAns();
    }

    private void checkAns(){
        out = "";
        if(ans1.equals("FRANCE")){
            out = out + "You got question 1 correct.\n";
        } else {
            out = out + "You got question 1 incorrect.\n";
        }
        if(ans2.equals("407")){
            out = out + "You got question 2 correct.";
        } else {
            out = out + "You got question 2 incorrect.";
        }
        tv.setText(out);
    }


}
