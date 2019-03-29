package com.example.darshan.miniproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class adminlogin extends AppCompatActivity implements View.OnClickListener{

    private Button bb;
    private EditText email;
    private EditText pass;


    private FirebaseAuth firebaseAuth;

    private ProgressDialog pD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        firebaseAuth=firebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            //Profile Activity here
            finish();
            startActivity(new Intent(getApplicationContext(), adminview.class));
        }

        email=(EditText)findViewById(R.id.adminemail);
        pass=(EditText)findViewById(R.id.adminpass);
        bb=(Button)findViewById(R.id.bbadmin);



        pD=new ProgressDialog(this);

        bb.setOnClickListener(this);



    }

    private void userLogin()
    {
        String loginemail=email.getText().toString().trim();
        String loginpassword=pass.getText().toString().trim();

        if(TextUtils.isEmpty(loginemail))
        {

            //To check if the email field is empty or not.
            Toast.makeText(this, "Please enter the email", Toast.LENGTH_LONG).show();
            return;
            //To stop the function from executing further.

        }
        if(TextUtils.isEmpty(loginpassword))
        {
            //To check if the password field is empty or not.
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
            //To stop the function from executing further.
        }
        //Will show progress dialog if validation without error.
        pD.setMessage("Logging in...");
        pD.show();

        firebaseAuth.signInWithEmailAndPassword(loginemail, loginpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pD.dismiss();
                        if (task.isSuccessful()){
                            //Start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), adminview.class));
                        }
                        else
                        {
                            Toast.makeText(adminlogin.this, "Login Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v==bb){
            userLogin();
        }
    }
}