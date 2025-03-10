package com.example.appdevelopment.CardViewExample;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appdevelopment.R;

import java.util.List;

public class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.ViewHolder>{
    public List<MyModel> list;
    Context context;
    public MyCardViewAdapter(Context context, List<MyModel> list) {
        this.context=context;
        this.list = list;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card_layout,parent,false);
        MyCardViewAdapter.ViewHolder obj=new MyCardViewAdapter.ViewHolder(view);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyModel obj=list.get(position);
        holder.Name.setText(obj.getName());
        holder.TotalDownload.setText(String.valueOf(obj.getTotalDownload()));
        Glide.with(context).load(obj.Thumbnail).into(holder.Thumbnail);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Thumbnail;
        TextView Name,TotalDownload;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Thumbnail=itemView.findViewById(R.id.imgCardView);
            Name=itemView.findViewById(R.id.txtCardView1);
            TotalDownload=itemView.findViewById(R.id.txtCardView2);
        }
    }
}