package com.example.todoapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView tv_item_task, tv_item_category;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_item_category = itemView.findViewById(R.id.tv_item_category);
        tv_item_task = itemView.findViewById(R.id.tv_item_task);
    }
}
