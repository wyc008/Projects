package com.wyc.sample.custom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wyc.sample.R;
import com.wyc.sample.custom.Itemdecoration.CustomItemDecoration;
import com.wyc.sample.custom.adapter.MyViewHolder;
import com.wyc.sample.custom.adapter.RecyclerViewAdapter;
import com.wyc.sample.custom.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends Activity {
    private static final String TAG = RecyclerViewActivity.class.getSimpleName();
    RecyclerView recyclerView;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);
        recyclerView = findViewById(R.id.recycler_view);
        if (recyclerView == null) return;
        initData();
        initView();
    }

    private void initView() {
        //线性布局
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layout);
        //默认动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //间距
        CustomItemDecoration itemDecoration = new CustomItemDecoration(10, 10, 50, 0);
        itemDecoration.setSpacing(100);
        recyclerView.addItemDecoration(itemDecoration);
        //加载数据适配器
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AdapterListener());
        adapter.setDataList(mList);
    }

    private void initData() {
        mList.add("亚特兰大老鹰");
        mList.add("夏洛特黄蜂");
        mList.add("迈阿密热火");
        mList.add("奥兰多魔术");
        mList.add("华盛顿奇才");
        mList.add("波士顿凯尔特人");
        mList.add("布鲁克林篮网");
        mList.add("纽约尼克斯");
        mList.add("费城76人");
        mList.add("多伦多猛龙");
        mList.add("芝加哥公牛");
        mList.add("克里夫兰骑士");
        mList.add("底特律活塞");
        mList.add("印第安纳步行者");
        mList.add("密尔沃基雄鹿");
        mList.add("达拉斯独行侠");
        mList.add("休斯顿火箭");
        mList.add("孟菲斯灰熊");
        mList.add("新奥尔良鹈鹕");
        mList.add("圣安东尼奥马刺");
        mList.add("丹佛掘金");
        mList.add("明尼苏达森林狼");
        mList.add("俄克拉荷马城雷霆");
        mList.add("波特兰开拓者");
        mList.add("犹他爵士");
        mList.add("金州勇士");
        mList.add("洛杉矶快船");
        mList.add("洛杉矶湖人");
        mList.add("菲尼克斯太阳");
        mList.add("萨克拉门托国王");
    }

    private class AdapterListener implements OnItemClickListener{

        @Override
        public void onClick(RecyclerView.ViewHolder holder, View view) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            Toast.makeText(RecyclerViewActivity.this, myViewHolder.getDisplayName(),
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLongClick(RecyclerView.ViewHolder holder, View view) {

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
