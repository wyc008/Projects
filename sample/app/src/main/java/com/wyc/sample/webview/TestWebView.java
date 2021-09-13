package com.wyc.sample.webview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.wyc.sample.R;

import androidx.annotation.Nullable;

public class TestWebView extends Activity {

    private static final String TAG = "TestWebView";

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate =========================");
        setContentView(R.layout.test_webview);
        webView = findViewById(R.id.webView);
        if (null == webView) {
            Log.e(TAG, "webView is null");
            return;
        }

        WebSettings webSettings = webView.getSettings();
        // 允许与Javascript交互
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());
        webView.loadUrl("https://www.baidu.com");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart ==========================");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart ========================");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume =====================");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause =====================");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop ====================");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy ===================");
    }
}
