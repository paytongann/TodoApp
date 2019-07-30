package com.example.todoapp;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<Pair<String,String>> dataSet;

    public CustomAdapter(List<Pair<String, String>> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        CustomViewHolder customerViewHolder = new CustomViewHolder(view);
        return customerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_item_task.setText(
                dataSet.get(position).first
        );
        holder.tv_item_category.setText(
                dataSet.get(position).second
        );
    }

    @Override
    public int getItemCount() {
        if (dataSet == null){
            return 0;
        } else {
            return dataSet.size();
            //ternary statement: return dataSet == null ?  0 : dataSet.size();
            // Question ?  true : false;
        }
    }
}