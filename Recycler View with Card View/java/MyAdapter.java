package com.example.recyclerviewwithcardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<Model> data;

    public MyAdapter(ArrayList<Model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.singlerow,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.t1.setText(data.get(i).getHeader());
        myViewHolder.t2.setText(data.get(i).getDesc());
        myViewHolder.img.setImageResource(data.get(i).getImageName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
