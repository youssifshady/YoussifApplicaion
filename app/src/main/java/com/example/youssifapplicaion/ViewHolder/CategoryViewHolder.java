package com.example.youssifapplicaion.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youssifapplicaion.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView txtPoemName;
    public TextView numberofpoem;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        txtPoemName = itemView.findViewById(R.id.shapeofiteminreccler);
        numberofpoem = itemView.findViewById(R.id.numberofpoem);
    }
}
