/*
 * *
 *  * Created by DemonApps on 01.12.2021, 15:35
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 27.11.2021, 16:35
 *
 */

package ru.demonapps.onlineradio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Onas extends AppCompatActivity {
    String url = "https://vk.com/kimrygarage";

    @TargetApi(Build.VERSION_CODES.ECLAIR_MR1)
    @RequiresApi(api = Build.VERSION_CODES.ECLAIR_MR1)
    @SuppressLint("SetJavaScriptEnabled")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onas);
        WebView mWebView = findViewById(R.id.webView);
        // устанавливаем Zoom control
        mWebView.getSettings().setBuiltInZoomControls(true);
        // создаем клиент
        mWebView.setWebViewClient(new MyWebViewClient());
        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        // делаем чтобы страница помещалась в размер экрана
        mWebView.setInitialScale(1);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        //Чистим кэш
        mWebView.clearCache(true);

        //Проверка подключения
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Objects.requireNonNull(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)).getState() == NetworkInfo.State.CONNECTED ||
                Objects.requireNonNull(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)).getState() == NetworkInfo.State.CONNECTED) {
            //Если есть интернет
            // указываем страницу загрузки
            mWebView.loadUrl(url);
        } else {
            //Если нет  интернета
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Необходимо подключение к сети...", Toast.LENGTH_LONG);
            toast.show();
            // Закрываем
            finish();
        }
    }

    private static class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}