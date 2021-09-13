package com.wyc.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wyc.sample.control.ControlViewTest;
import com.wyc.sample.custom.CustomView;
import com.wyc.sample.http.HttpTest;
import com.wyc.sample.webview.TestWebView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.test1).setOnClickListener(this);
        findViewById(R.id.test2).setOnClickListener(this);
        findViewById(R.id.test3).setOnClickListener(this);
        findViewById(R.id.test4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test1:
                Intent webView = new Intent();
                webView.setClass(this, TestWebView.class);
                startActivity(webView);
                break;
            case R.id.test2:
                Intent controlView = new Intent();
                controlView.setClass(this, ControlViewTest.class);
                startActivity(controlView);
                break;
            case R.id.test3:
                Intent customView = new Intent();
                customView.setClass(this, CustomView.class);
                startActivity(customView);
                break;
            case R.id.test4:
                Intent http = new Intent();
                http.setClass(this, HttpTest.class);
                startActivity(http);
                break;
            default:
                break;
        }
    }
}
