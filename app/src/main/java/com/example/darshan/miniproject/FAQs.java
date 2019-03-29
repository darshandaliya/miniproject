package com.example.darshan.miniproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class FAQs extends AppCompatActivity {

    ExpandableTextView expandableTextView;
    String question1="Question 1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        //expandableTextView =(ExpandableTextView)findViewById(R.id.expandabletv1);
       expandableTextView.setText(question1);

    }
}
