package com.example.darshan.miniproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CustomerService extends Fragment {


    View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       myView=inflater.inflate(R.layout.customerservice,container,false);
//        ed1=(EditText)myView.findViewById(R.id.editText1);
//        ed2=(EditText)myView.findViewById(R.id.editText2);
//        ed3=(EditText)myView.findViewById(R.id.editText3);
//        ed4=(EditText)myView.findViewById(R.id.editText4);

        return myView;


    }
}
