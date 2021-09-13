package com.wyc.sample.custom.listener;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * author : Michael Wang
 * e-mail : 1396794927@qq.com
 * date   : 2020/4/11/17:39
 * desc   : 点击事件监听器
 * version: 1.0
 */
public interface OnItemClickListener {
    /**
     * 点击事件回调函数
     */
    void onClick(RecyclerView.ViewHolder holder, View view);

    /**
     * 长按事件回调函数
     */
    void onLongClick(RecyclerView.ViewHolder holder, View view);
}
