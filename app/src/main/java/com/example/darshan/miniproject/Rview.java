package com.example.darshan.miniproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Rview extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout drawer;

    private FirebaseAuth firebaseAuth;

    private TextView textViewUserEmail;
    private Button buttonLogout;

    List<Product> Product1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Product1 = new ArrayList<>();
        Product1.add(new Product("Mobile 1", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 2", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 3", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 4", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 5", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 6", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 7", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 8", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 9", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));
        Product1.add(new Product("Mobile 10", "Category Mobile", "Description Mobile", R.drawable.ic_launcher_background));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, Product1);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);


        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, login.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();


        textViewUserEmail = (TextView) findViewById(R.id.UserEmail);

        textViewUserEmail.setText("Welcome " + user.getEmail());

        buttonLogout = (Button) findViewById(R.id.Logout);

        buttonLogout.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        if (v == buttonLogout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, cover.class));
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_customerservice:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CustomerService()).commit();
                break;

            case R.id.nav_news:
                finish();
                startActivity(new Intent(this, newsapp.class));
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.isDrawerOpen(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}


