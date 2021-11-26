/*
 * *
 *  * Created by DemonApps on 06.05.19 20:01
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 28.04.19 20:14
 *
 */

package ru.demonapps.onlineradio;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Zastavka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zastavka);

        //Создаем новый поток:
        Thread splash_time = new Thread()
        {
            public void run()
            {
                try
                {
                    //Целое значение время отображения картинки:
                    int SplashTimer = 0;
                    //Запускаем цикл длиной в 3 секунды:
                    while(SplashTimer < 3000) {
                        sleep(100);
                        SplashTimer = SplashTimer +100;
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace(); }
                finally {
                    //Закрываем activity:
                    finish();
                    startActivity(new Intent(Zastavka.this,MainActivity.class));
                }
            }
        };
        splash_time.start();

    }
}

