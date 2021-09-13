package com.wyc.sample.http;

import android.app.Activity;
import android.os.Bundle;

import com.wyc.sample.R;

import androidx.annotation.Nullable;

public class HttpTest extends Activity {
    private static final String TAG = "HttpTest";
    public HttpTest() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_http);
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
