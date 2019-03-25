package com.example.darshan.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button buttonmobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, login.class));
        }

        FirebaseUser user=firebaseAuth.getCurrentUser();


        textViewUserEmail=(TextView)findViewById(R.id.UserEmail);

        textViewUserEmail.setText("Welcome "+user.getEmail());

        buttonLogout=(Button)findViewById(R.id.Logout);

        buttonLogout.setOnClickListener(this);
        buttonmobi=(Button)findViewById(R.id.mobi);
        buttonmobi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, cover.class));
        }
        if(v==buttonmobi){
            finish();
            startActivity(new Intent(this,Rview.class));
        }
    }
}
