package com.wyc.sample.webview;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MyWebChromeClient extends WebChromeClient{
    private static final String TAG = "MyWebChromeClient";
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
//            super.onProgressChanged(view, newProgress);
        Log.d(TAG, "onProgressChanged ----------------- " + newProgress);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        Log.d(TAG, "onReceivedTitle ----------------- " + title);
        super.onReceivedTitle(view, title);
    }

    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        super.onReceivedIcon(view, icon);
    }

    @Override
    public void onHideCustomView() {
        super.onHideCustomView();
    }

    @Override
    public void onRequestFocus(WebView view) {
        super.onRequestFocus(view);
    }
}
