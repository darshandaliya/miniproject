package com.example.darshan.miniproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
//import com.example.darshan.miniproject.MobileDetail;
import com.example.darshan.miniproject.model.Mobile;
import com.example.darshan.miniproject.R;
import com.example.darshan.miniproject.model.Mobile;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    RequestOptions options ;
    private Context mContext ;
    private List<Mobile> mData ;


    public RvAdapter(Context mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.mobile_row_item,parent,false);
        // click listener here
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.mname.setText(mData.get(position).getName());
        holder.mprice.setText(mData.get(position).getPrice());
        holder.mram.setText(mData.get(position).getRAM());
        holder.mss.setText((int) mData.get(position).getScreen_Size());
        holder.mstorage.setText(mData.get(position).getStorage());



        // load image from the internet using Glide
        // Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.MobileThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mname,mprice,mstorage,mram,mss;
        ImageView MobileThumbnail;


        public MyViewHolder(View itemView) {
            super(itemView);
            mname = itemView.findViewById(R.id.modelname);
            mprice = itemView.findViewById(R.id.price);
            mram = itemView.findViewById(R.id.RAM);
            mss = itemView.findViewById(R.id.screen_size);
            mstorage = itemView.findViewById(R.id.storage);
            MobileThumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }


}
