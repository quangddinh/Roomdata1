package com.example.roomdatabase26112019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase26112019.model.database.Sinhvien;

import java.util.ArrayList;

public class SinhvienAdapter extends RecyclerView.Adapter<SinhvienAdapter.SinhvienViewHolder> {

    private ArrayList<Sinhvien> mArraySv;

    public  SinhvienAdapter(ArrayList<Sinhvien> mArraySv) {
        this.mArraySv = mArraySv;
    }

    @NonNull
    @Override
    public SinhvienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_sinhvien,parent,false);
        SinhvienViewHolder holder = new SinhvienViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SinhvienViewHolder holder, int position) {
        Sinhvien sinhvien = mArraySv.get(position);
        holder.mTvTen.setText(sinhvien.getTen());
        holder.mTvNamsinh.setText(String.valueOf(sinhvien.getNamsinh()));
        holder.mTvDiaChi.setText(sinhvien.getDiachi());

    }

    @Override
    public int getItemCount() {
        return mArraySv!= null ? mArraySv.size() : 0;
    }

    class SinhvienViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTen, mTvNamsinh, mTvDiaChi;

        public SinhvienViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvTen = itemView.findViewById(R.id.tv_name);
            mTvNamsinh = itemView.findViewById(R.id.tv_year);
            mTvDiaChi = itemView.findViewById(R.id.tv_address);

        }
    }
}
