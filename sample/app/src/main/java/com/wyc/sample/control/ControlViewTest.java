package com.wyc.sample.control;

import android.app.Activity;
import android.os.Bundle;

import com.wyc.sample.R;

import androidx.annotation.Nullable;

public class ControlViewTest extends Activity {
    private static final String TAG = "ControlViewTest";
    public ControlViewTest() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_control_view);
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
}
