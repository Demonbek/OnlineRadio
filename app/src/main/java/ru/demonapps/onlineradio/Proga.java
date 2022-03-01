/*
 * *
 *  * Created by DemonApps on 02.03.2022, 0:31
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 02.03.2022, 0:25
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