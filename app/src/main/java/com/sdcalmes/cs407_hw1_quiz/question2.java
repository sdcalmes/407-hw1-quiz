package com.sdcalmes.cs407_hw1_quiz;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class question2 extends android.app.Fragment {

    private Button mSubmit;
    private RadioGroup mRadioGroup;
    public question2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question2, container, false);
        mSubmit = (Button)view.findViewById(R.id.button3);
        mRadioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRadioGroup.getCheckedRadioButtonId() != -1){
                    int id = mRadioGroup.getCheckedRadioButtonId();
                    View radioButton = mRadioGroup.findViewById(id);
                    int radioId = mRadioGroup.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) mRadioGroup.getChildAt(radioId);
                    String selection = (String)btn.getText();
                    ((MainActivity)getActivity()).getAns2Data(selection.toUpperCase());
                    System.out.println("SHOULD CLOSE FRAGMENT");
                    FragmentManager fm = getActivity().getFragmentManager();
                    getActivity().getFragmentManager().beginTransaction()
                            .remove(getFragmentManager()
                                    .findFragmentById(R.id.fragment_holder))
                            .commit();
                }
                else{
                    Toast.makeText(getActivity(), "You need to select an answer.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
