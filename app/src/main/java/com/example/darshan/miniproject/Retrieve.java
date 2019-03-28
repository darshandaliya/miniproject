package com.example.darshan.miniproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.telecom.Call;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.darshan.miniproject.Mobile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Retrieve extends AppCompatActivity implements SearchView.OnQueryTextListener {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Mobile> list;
    TextView tv1,tv2,tv3,tv4,tv5;
    RvAdapter adapter;
    private android.support.v7.widget.Toolbar toolbar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView)findViewById(R.id.rv);
        list=new ArrayList<Mobile>();
        reference=FirebaseDatabase.getInstance().getReference().child("Mobile");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Mobile mobile=dataSnapshot1.getValue(Mobile.class);
                    list.add(mobile);
                }

                adapter=new RvAdapter(Retrieve.this,list);
                recyclerView.setAdapter(adapter);
                RecyclerView.LayoutManager recycleVariable = new LinearLayoutManager(Retrieve.this);
                recyclerView.setLayoutManager(recycleVariable);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);


        return true;
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onQueryTextSubmit(String s) {



        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        String userInput= s.toLowerCase();
        ArrayList<Mobile> newList=new ArrayList<>();

        for (Mobile name: list)
        {

           if(name.getModel().toLowerCase().contains(userInput))
           {
               newList.add(name);

           }

        }

        adapter.updateList(newList);
        return true;
    }
}
