package com.wyc.sample.custom.adapter;

import android.view.View;
import android.widget.TextView;

import com.wyc.sample.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{

    TextView textView, position;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        position = itemView.findViewById(R.id.list_position);
        textView = itemView.findViewById(R.id.recycler_view_item );
    }

    public String getDisplayName(){
        return  textView.getText().toString();
    }
}
