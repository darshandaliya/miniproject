package com.example.darshan.miniproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class adminview extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminview);

        drawerLayout=findViewById(R.id.adminview);
        NavigationView navigationView=findViewById(R.id.adminnavigationview);
        firebaseAuth=FirebaseAuth.getInstance();
//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.headericon);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();
                if(id==R.id.nav_faqf){

                    Intent intent=new Intent(adminview.this,FAQs.class);
                    startActivity(intent);
                }

                else if(id==R.id.nav_newsf){
                    Intent intent=new Intent(adminview.this,newsapp.class);
                    startActivity(intent);
                }

                else if(id==R.id.nav_customerservicef){
                    Intent intent=new Intent(adminview.this,CustomerService.class);
                    startActivity(intent);
                }

                else if (id==R.id.nav_logoutf)
                {
                    firebaseAuth.signOut();
                    finish();
                    Intent intent=new Intent(adminview.this,cover.class);
                    startActivity(intent);
                }

                else if(id==R.id.nav_addproducts){

                }

                return true;

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
