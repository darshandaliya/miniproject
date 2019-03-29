package com.example.darshan.miniproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class faq_customer extends AppCompatActivity {

    TextView q1;
    TextView q2;
    TextView a1;
    TextView a2;
    TextView q3;
    TextView a3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_customer);

        q1=(TextView)findViewById(R.id.question1);
        q2=(TextView)findViewById(R.id.question2);
        q3=(TextView)findViewById(R.id.question3);
        a1=(TextView)findViewById(R.id.answer1);
        a2=(TextView)findViewById(R.id.answer2);
        a3=(TextView)findViewById(R.id.answer3);
    }
}
