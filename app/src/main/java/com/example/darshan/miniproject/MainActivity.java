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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonsignup;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    //private ImageView iv1;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing firebase auth object
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            //Profile Activity here
            finish();
            startActivity(new Intent(getApplicationContext(), navigationfinal.class));
        }

        progressDialog=new ProgressDialog(this);


        buttonsignup=(Button)findViewById(R.id.button);
        editTextEmail=(EditText)findViewById(R.id.editText4);
        editTextPassword=(EditText)findViewById(R.id.editText3);
        textViewSignin=(TextView)findViewById(R.id.textView);
        //iv1=(ImageView)findViewById(R.id.v1);


        buttonsignup.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }
    private void signupUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {

            //To check if the email field is empty or not.
            Toast.makeText(this, "Please enter the email", Toast.LENGTH_LONG).show();
            return;
            //To stop the function from executing further.

        }
        if (TextUtils.isEmpty(password)) {
            //To check if the password field is empty or not.
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
            //To stop the function from executing further.
        }
        //Will show progress dialog if validation without error.
        progressDialog.setMessage("Registering User...");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {

                                //Profile Activity here
                            finish();
                            startActivity(new Intent(getApplicationContext(), navigationfinal.class));

                            //User registered Successfully.
                            //Logs in and redirects to the homepage.
                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }
                    }
                });


    }

    @Override
    public void onClick(View v) {
        if (v==buttonsignup) {
            signupUser();
        }
        if(v==textViewSignin){
            finish();
            startActivity(new Intent(this, login.class));
        }

    }
}
