package com.wyc.sample.custom;

import android.app.Activity;
import android.os.Bundle;

import com.wyc.sample.R;

import androidx.annotation.Nullable;

public class CustomViewActivity extends Activity {

    private CustomView customView;

    public CustomViewActivity() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cust_view_layout);
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
