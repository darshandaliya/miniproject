package com.example.darshan.miniproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.darshan.miniproject.R;
import com.example.darshan.miniproject.Mobile;

import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private Context mcontext;
    private ArrayList<Mobile> mData;

    public RvAdapter(Context mcontext, ArrayList<Mobile> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }
    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView mname,mprice,mstorage,mram,mss;





        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mname = itemView.findViewById(R.id.modelname);
            mprice = itemView.findViewById(R.id.price);
            mram = itemView.findViewById(R.id.RAM);
            mss = itemView.findViewById(R.id.screen_size);
            mstorage = itemView.findViewById(R.id.storage);

        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        view=inflater.inflate(R.layout.mobile_row_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        myViewHolder.mname.setText(String.valueOf(mData.get(i).getModel()));
        myViewHolder.mprice.setText(String.valueOf(mData.get(i).getPrice()));
        myViewHolder.mram.setText(String.valueOf(mData.get(i).getRAM()));
        myViewHolder.mss.setText(String.valueOf(mData.get(i).getScreen_Size()));
        myViewHolder.mstorage.setText(String.valueOf(mData.get(i).getStorage()));



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



}
