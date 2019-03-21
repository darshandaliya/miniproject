package com.example.darshan.miniproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class navigationfinal extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationfinal);
        drawerLayout=findViewById(R.id.DL);
        NavigationView navigationView=findViewById(R.id.finalnavigationview);
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
                if(id==R.id.nav_newsf)
                {

                    finish();
                    Intent intent=new Intent(navigationfinal.this,newsapp.class);
                    startActivity(intent);
                }
                else if (id==R.id.nav_customerservicef)
                {
                    finish();
                    Intent intent=new Intent(navigationfinal.this,CustomerService.class);
                    startActivity(intent);
                }
                else if (id==R.id.nav_logoutf)
                {
                    finish();
                    Intent intent=new Intent(navigationfinal.this,MainActivity.class);
                    startActivity(intent);
                }
                else if (id==R.id.nav_faqf)
                {
                    finish();
                    Intent intent=new Intent(navigationfinal.this,FAQs.class);
                    startActivity(intent);
                }
                else if (id==R.id.nav_settingsf)
                {
                    finish();
                    Intent intent=new Intent(navigationfinal.this,settings.class);
                    startActivity(intent);
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
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
