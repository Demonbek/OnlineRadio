/*
 * *
 *  * Created by DemonApps on 01.12.2021, 15:35
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 27.11.2021, 16:35
 *
 */

package ru.demonapps.onlineradio;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Proga extends AppCompatActivity {
    TextView textView4;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proga);
        textView4 = findViewById(R.id.textView4);
        textView4.setText("Версия: " + BuildConfig.VERSION_NAME);
    }
}