package com.wyc.sample.custom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyc.sample.R;
import com.wyc.sample.custom.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private static final String TAG = RecyclerViewAdapter.class.getSimpleName();
    /**
     * 点击事件监听器
     */
    private OnItemClickListener onItemClickListener;
    /**
     * 上下文
     */
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setDataList(List<String> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public void  setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
        holder.position.setText(String.valueOf(position + 1));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onItemClickListener){
                    onItemClickListener.onClick(holder,v);
                }
            }
        });
        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (null != onItemClickListener){
                    onItemClickListener.onLongClick(holder, v);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}

