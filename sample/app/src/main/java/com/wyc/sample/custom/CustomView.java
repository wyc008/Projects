package com.wyc.sample.custom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wyc.sample.R;

import androidx.annotation.Nullable;

public class CustomView extends Activity implements View.OnClickListener {
    private static final String TAG = "CustomView";
    public CustomView() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_custom_view);
        findViewById(R.id.custom_test1).setOnClickListener(this);
        findViewById(R.id.custom_test2).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.custom_test1:
                Intent recyclerView = new Intent();
                recyclerView.setClass(this, RecyclerViewActivity.class);
                startActivity(recyclerView);
                break;
            case R.id.custom_test2:
                Intent customView = new Intent();
                customView.setClass(this, CustomViewActivity.class);
                startActivity(customView);
                break;
            default:
                break;
        }
    }
}
