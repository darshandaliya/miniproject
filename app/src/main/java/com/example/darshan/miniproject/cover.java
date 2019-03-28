package com.example.darshan.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class cover extends AppCompatActivity implements View.OnClickListener {

    private Button newu;
    private Button exist;
    private ImageView iv3;
    private Button adminbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        newu=(Button)findViewById(R.id.newuser);
        exist=(Button)findViewById(R.id.existinguser);
        iv3=(ImageView)findViewById(R.id.v3);
        adminbutton=(Button)findViewById(R.id.adminbutton);

        newu.setOnClickListener(this);
        exist.setOnClickListener(this);
        adminbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==newu)
        {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        if (v==exist)
        {
            finish();
            startActivity(new Intent(this, login.class));
        }
        if(v==adminbutton)
        {
            finish();
            startActivity(new Intent(this,adminlogin.class));
        }
    }
}
