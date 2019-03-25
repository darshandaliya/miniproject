package com.example.darshan.miniproject;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.darshan.miniproject.R;
import com.example.darshan.miniproject.RvAdapter;
import com.example.darshan.miniproject.model.Mobile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Rview extends AppCompatActivity {
    private String URL_JSON = "https://api.myjson.com/bins/l9ljm";
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<Mobile> lstMobile = new ArrayList<>();
    private RecyclerView myrv ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rview);
        myrv = findViewById(R.id.rv);
        jsoncall();




    }

    public void jsoncall() {


        ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {

                    //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                    try {

                        jsonObject = response.getJSONObject(i);
                        Mobile mobile = new Mobile();

                        mobile.setModel(jsonObject.getString("Model"));
                        mobile.setPrice(jsonObject.getInt("Price"));
                        mobile.setRAM(jsonObject.getInt("RAM(GB)"));
                        mobile.setScreen_Size(jsonObject.getDouble("Screen Size(inches)"));
                        mobile.setStorage(jsonObject.getInt("Storage(GB)"));
                        //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                        lstMobile.add(mobile);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                Toast.makeText(Rview.this,"Size of Liste "+String.valueOf(lstMobile.size()),Toast.LENGTH_SHORT).show();
                Toast.makeText(Rview.this,lstMobile.get(1).toString(),Toast.LENGTH_SHORT).show();

                setRvadapter(lstMobile);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(Rview.this);
        requestQueue.add(ArrayRequest);
    }



    public void setRvadapter (List<Mobile> lst) {

        RvAdapter myAdapter = new RvAdapter(this,lst) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);




    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
//
//        MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
//            @Override
//            public boolean onMenuItemActionExpand(MenuItem item) {
//                return true;
//            }
//
//            @Override
//            public boolean onMenuItemActionCollapse(MenuItem item) {
//                return true;
//            }
//        };
//
//        MenuItem searchItem=menu.findItem(R.id.action_search);
//
//        searchItem.setOnActionExpandListener(onActionExpandListener);
//
//
//
//        return true;
//    }
}