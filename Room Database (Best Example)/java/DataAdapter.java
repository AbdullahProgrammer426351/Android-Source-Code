package com.example.databaselistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private List<MyDetailInfo> myDetailInfoList;
    private Context mContext;

    public DataAdapter(DetailActivity detailActivity, List<MyDetailInfo> myDetailInfos) {
        this.myDetailInfoList = myDetailInfos;
        this.mContext = detailActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userName.setText(myDetailInfoList.get(position).getName());
        holder.fatherName.setText(myDetailInfoList.get(position).getFatherName());
        holder.phoneNumber.setText(myDetailInfoList.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return myDetailInfoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userName, fatherName, phoneNumber;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.tvUserName);
            fatherName = itemView.findViewById(R.id.tvFatherName);
            phoneNumber = itemView.findViewById(R.id.tvPhone);
        }
    }
}
