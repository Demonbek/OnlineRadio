/*
 * *
 *  * Created by DemonApps on 04.02.2022, 16:28
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 04.02.2022, 16:20
 *
 */

package ru.demonapps.onlineradio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import java.io.IOException;

public class MainActivity extends Activity implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener {

    final String LOG_TAG = "myLogs";
    //final String DATA_RADIO1 = "http://cdn.radio1.news:8000/rtvp_mp3";
    final String DATA_BIKER = "https://listen4.myradio24.com/69846";
    final String DATA_MOTO = "https://stream.motoradio.online/high-mp3";
    final String DATA_HARDRADIO = "http://144.217.29.205/live?type=http&nocache=66371";
    final String DATA_MENTY = "https://radiomv.hostingradio.ru:80/radiomv128.mp3";
    final String DATA_NASHE = "https://nashe1.hostingradio.ru:80/nashe-128.mp3";
    final String DATA_NASHE20 = "https://nashe1.hostingradio.ru:18000/nashe20-128.mp3";
    final String DATA_COMEDY = "https://ic6.101.ru:8000/stream/air/aac/64/202";
    final String DATA_AVTO = "https://ic7.101.ru:8000/v3_1";
    final String DATA_RETRO = "https://emgregion.hostingradio.ru:8064/moscow.retrofm.mp3";
    final String DATA_ZAICEV = "https://zaycevfm.cdnvideo.ru/ZaycevFM_pop_256.mp3";
    final String DATA_PIONER = "https://radio-node-2.dline-media.com/ppr128.mp3";
    final String DATA_ULTRA = "https://nashe1.hostingradio.ru:80/ultra-128.mp3";
    final String DATA_SOUZ = "https://soyuzfm.su:9000//soyuzfm-320.mp3";
    final String DATA_CHOCOLAD = "https://choco.hostingradio.ru:10010/fm";
    final String DATA_DISCO_USSR = "https://listen4.myradio24.com/dance80";
    final String DATA_HITFM = "https://hitfm.hostingradio.ru/hitfm128.mp3";
    final String DATA_ROMATIKA = "https://ic4.101.ru:8050/v4_1";
    final String DATA_RELAX = "https://pub0302.101.ru:8443/stream/air/aac/64/200";
    final String DATA_RNR = "https://a6.radioheart.ru:9046/RH1972";
    final String DATA_UMOR = "https://pub0301.101.ru:8443/stream/air/mp3/256/102";
    final String DATA_DOR = "https://dorognoe.hostingradio.ru:8000/dorognoe";
    final String DATA_ROCKSTATION = "https://rockstation.radiostream.pro/mp3";
    final String DATA_NESTANDART = "https://listen.radionestandart.ru:8200/128.mp3";
    MediaPlayer mediaPlayer;
    AudioManager am;
    ScrollView myScroll;
    ImageView imageVibor;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        imageVibor = findViewById(R.id.imageVibor);
        imageVibor.setVisibility(View.VISIBLE);
        myScroll = findViewById(R.id.myScroll);
    }


    @SuppressLint("NonConstantResourceId")
    public void onClickStart(View view) {
        releaseMP();

        try {
            switch (view.getId()) {
                case R.id.btnHARDRADIO:
                    Log.d(LOG_TAG, "start RADIO1");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_HARDRADIO);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    Log.d(LOG_TAG, "prepareAsync");
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.hardradio);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.hardradio);
                    break;
                case R.id.btnBiker:
                    Log.d(LOG_TAG, "start Biker FM");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_BIKER);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    Log.d(LOG_TAG, "prepareAsync");
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.biker_fm);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.biker);
                    break;
                case R.id.btnMoto:
                    Log.d(LOG_TAG, "start MotoRadio");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_MOTO);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    Log.d(LOG_TAG, "prepareAsync");
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.motoradio);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.moto);
                    break;
                case R.id.btnMenty:
                    Log.d(LOG_TAG, "start MENTY");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_MENTY);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    Log.d(LOG_TAG, "prepareAsync");
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.milicia);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.menty);
                    break;
                case R.id.btnNashe:
                    Log.d(LOG_TAG, "start NASHE");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_NASHE);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.nashe);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.nashe);
                    break;
                case R.id.btnNashe20:
                    Log.d(LOG_TAG, "start NASHE20");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setDataSource(DATA_NASHE20);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.nashe20);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.nashe20);
                    break;
                case R.id.btnComedy:
                    Log.d(LOG_TAG, "start Comedy");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_COMEDY);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.comedy);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.comedy);
                    break;
                case R.id.btnAvto:
                    Log.d(LOG_TAG, "start Avto");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_AVTO);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.avto);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.avto);
                    break;
                case R.id.btnRetro:
                    Log.d(LOG_TAG, "start Retro");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_RETRO);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.retrofm);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.retro);
                    break;
                case R.id.btnZaicev:
                    Log.d(LOG_TAG, "start ZAICEV");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_ZAICEV);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.zaycev);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.zaicev);
                    break;
                case R.id.btnPioner:
                    Log.d(LOG_TAG, "start Pioner");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_PIONER);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.pioner);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.pioner);
                    break;
                case R.id.btnUltra:
                    Log.d(LOG_TAG, "start ULTRA");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_ULTRA);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.ultra);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.ultra);
                    break;
                case R.id.btnSouz:
                    Log.d(LOG_TAG, "start SOUZ");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_SOUZ);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.soyuz_fm);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.souz);
                    break;
                case R.id.btnChocolad:
                    Log.d(LOG_TAG, "start CHOCOLAD");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_CHOCOLAD);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.chocolate);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.chocolate);
                    break;
                case R.id.btnDisco_ussr:
                    Log.d(LOG_TAG, "start DISCO_USSR");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_DISCO_USSR);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.diskoteka_sssr);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.diskoteka_sssr);
                    break;
                case R.id.btnHitFm:
                    Log.d(LOG_TAG, "start HITFM");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_HITFM);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.hitfm);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.hitfm);
                    break;
                case R.id.btnRomantika:
                    Log.d(LOG_TAG, "start ROMATIKA");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_ROMATIKA);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.romantika);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.romantika);
                    break;
                case R.id.btnRelax:
                    Log.d(LOG_TAG, "start RELAX");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_RELAX);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.relaxfm);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.relax);
                    break;
                case R.id.btnRnr:
                    Log.d(LOG_TAG, "start RNR");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_RNR);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.rock_n_roll_fm);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.rnr);
                    break;
                case R.id.btnUmor:
                    Log.d(LOG_TAG, "start UMOR");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_UMOR);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.umor);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.umor);
                    break;
                case R.id.btnDor:
                    Log.d(LOG_TAG, "start DOR");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_DOR);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.dor);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.dor);
                    break;
                case R.id.btnRockstation:
                    Log.d(LOG_TAG, "start AVTODOR");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_ROCKSTATION);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.rockstation);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.rockstation);
                    break;
                case R.id.btnNestandart:
                    Log.d(LOG_TAG, "start NESTANDART");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_NESTANDART);
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes
                                    .Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build());
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.nestandart);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0, 0);
                    setTitle(R.string.nestandart);
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (mediaPlayer == null)
            return;

        mediaPlayer.setOnCompletionListener(this);
    }

    private void releaseMP() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        if (mediaPlayer == null)
            return;
        switch (view.getId()) {
            case R.id.btnPause:
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
                break;
            case R.id.btnResume:
                if (!mediaPlayer.isPlaying())
                    mediaPlayer.start();
                progressBar.setVisibility(View.VISIBLE);
                break;
            case R.id.btnStop:
                mediaPlayer.stop();
                progressBar.setVisibility(View.INVISIBLE);
                progressBar.setBackgroundColor(Color.WHITE);
                imageVibor.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                myScroll.scrollTo(0, 0);
                setTitle(R.string.app_name);
                break;
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.d(LOG_TAG, "onPrepared");
        mp.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.d(LOG_TAG, "onCompletion");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMP();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_settings1:

                Intent intent = new Intent(this, Proga.class);
                startActivity(intent);
                return true;
            case R.id.action_settings2:
                Intent intentOnas = new Intent(this, Onas.class);
                startActivity(intentOnas);
                return true;
            case R.id.action_settings3:
                Intent intentOtherApps = new Intent(this, OtherApps.class);
                startActivity(intentOtherApps);
                return true;
            case R.id.action_settings4:
                Intent intentVideo = new Intent(this, Video.class);
                startActivity(intentVideo);
                return true;
            case R.id.action_settings5:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Советую приложение 'Радио Он-Лайн'\nhttps://play.google.com/store/apps/details?id=ru.demonapps.onlineradio" );
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent,"Поделиться приложением..."));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
