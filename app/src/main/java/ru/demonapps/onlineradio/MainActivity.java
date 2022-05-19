/*
 * *
 *  * Created by DemonApps on 02.03.2022, 0:31
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 02.03.2022, 0:25
 *
 */

package ru.demonapps.onlineradio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdEventListener;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.common.ImpressionData;

import java.io.IOException;

public class MainActivity extends Activity implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener {
    private static final String blockId = "R-M-1574620-1";
    private BannerAdView mBannerAdViewRadio;
    final String LOG_TAG = "myLogs";
    String url;
    int title, pic;
    public static final String STORAGE_NAME = "lastRadio";
    //Ссылки на потоки
    final String DATA_BIKER = "https://listen4.myradio24.com/69846";
    final String DATA_MOTO = "https://stream.motoradio.online/high-mp3";
    final String DATA_HARDRADIO = "http://144.217.29.205/live?type=http&nocache=66371";
    final String DATA_MENTY = "https://radiomv.hostingradio.ru:80/radiomv128.mp3";
    final String DATA_NASHE = "https://nashe1.hostingradio.ru:80/nashe-128.mp3";
    final String DATA_NASHE20 = "https://nashe1.hostingradio.ru:18000/nashe20-128.mp3";
    final String DATA_COMEDY = "http://178.218.20.171:31804/COMEDY_KAB_MP3";
    final String DATA_AVTO = "https://ic7.101.ru:8000/v3_1";
    final String DATA_RETRO = "https://emgregion.hostingradio.ru:8064/moscow.retrofm.mp3";
    final String DATA_ZAICEV = "https://zaycevfm.cdnvideo.ru/ZaycevFM_pop_256.mp3";
    final String DATA_PIONER = "https://radio-node-2.dline-media.com/ppr128.mp3";
    final String DATA_ULTRA = "https://nashe1.hostingradio.ru:80/ultra-128.mp3";
    final String DATA_SOUZ = "https://soyuzfm.su:9000//soyuzfm-320.mp3";
    final String DATA_CHOCOLAD = "https://choco.hostingradio.ru:10010/fm";
    final String DATA_DISCO_USSR = "https://listen4.myradio24.com/dance80";
    final String DATA_HITFM = "https://hitfm.hostingradio.ru/hitfm128.mp3";
    final String DATA_ROMATIKA = "https://ic4.101.ru:8000/s30";
    final String DATA_RELAX = "https://zaycevfm.cdnvideo.ru/ZaycevFM_relax_256.mp3";
    final String DATA_RNR = "https://a6.radioheart.ru:9046/RH1972";
    final String DATA_UMOR = "https://pub0301.101.ru:8443/stream/air/mp3/256/102";
    final String DATA_DOR = "https://dorognoe.hostingradio.ru:8000/dorognoe";
    final String DATA_ROCKSTATION = "https://rockstation.radiostream.pro/mp3";
    final String DATA_NESTANDART = "https://listen.radionestandart.ru:8200/128.mp3";
    final String DATA_R13 = "http://play1.radio13.ru./mp3";
    final String DATA_SHOCK = "http://spb.radioshock.ru/radioshock";
    final String DATA_PANKY = "https://nashe1.hostingradio.ru/nashepunks.mp3";
    final String DATA_ISKATEL = "https://iskatel.hostingradio.ru:8015/iskatel-128.mp3";
    //Медиа плеер
    MediaPlayer mediaPlayer;
    AudioManager am;
    ScrollView myScroll;
    ImageView imageVibor;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Инициализация медиа плеера
        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        imageVibor = findViewById(R.id.imageVibor);
        imageVibor.setVisibility(View.VISIBLE);
        myScroll = findViewById(R.id.myScroll);
        SharedPreferences settings = this.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        url = settings.getString("url", "");
        title = settings.getInt("title", R.string.app_name);
        pic = settings.getInt("pic", R.drawable.vibor);
        Log.d(LOG_TAG, "прочитано "+url+" "+getString(title)+" "+getString(pic));
        try {
            onPlay(url, title, pic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Создание экземпляра mBannerAdView.
        mBannerAdViewRadio = findViewById(R.id.banner_ad_viewRadio);
        mBannerAdViewRadio.setAdUnitId(blockId);
        mBannerAdViewRadio.setAdSize(AdSize.BANNER_320x50);

        // Создание объекта таргетирования рекламы.
        final AdRequest adRequest = new AdRequest.Builder().build();

        // Регистрация слушателя для отслеживания событий, происходящих в баннерной рекламе.
        mBannerAdViewRadio.setBannerAdEventListener(new BannerAdEventListener() {
            @Override
            public void onAdLoaded() {
                mBannerAdViewRadio.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {

            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onLeftApplication() {

            }

            @Override
            public void onReturnedToApplication() {

            }

            @Override
            public void onImpression(@Nullable ImpressionData impressionData) {

            }
        });
        // Загрузка объявления.
        mBannerAdViewRadio.loadAd(adRequest);

    }

    @SuppressLint("NonConstantResourceId")
    public void onClickStart(View view) {
        releaseMP();

        try {
            switch (view.getId()) {
                case R.id.btnHARDRADIO:
                    Log.d(LOG_TAG, "start HARDRADIO");
                    onPlay(DATA_HARDRADIO, R.string.hardradio,R.drawable.hardradio);
                    break;

                case R.id.btnComedy:
                    Log.d(LOG_TAG, "start Camedy");
                    onPlay(DATA_COMEDY, R.string.comedy, R.drawable.comedy);
                    break;
                case R.id.btnBiker:
                    Log.d(LOG_TAG, "start Biker FM");
                    onPlay(DATA_BIKER, R.string.biker, R.drawable.biker);
                    break;
                case R.id.btnMoto:
                    Log.d(LOG_TAG, "start MotoRadio");
                    onPlay(DATA_MOTO, R.string.moto, R.drawable.moto);
                    break;
                case R.id.btnMenty:
                    Log.d(LOG_TAG, "start MENTY");
                    onPlay(DATA_MENTY, R.string.menty, R.drawable.menty);
                    break;
                case R.id.btnNashe:
                    Log.d(LOG_TAG, "start NASHE");
                    onPlay(DATA_NASHE, R.string.nashe, R.drawable.nashe);
                    break;
                case R.id.btnNashe20:
                    Log.d(LOG_TAG, "start NASHE20");
                    onPlay(DATA_NASHE20, R.string.nashe20, R.drawable.nashe20);
                    break;
                case R.id.btnPanky:
                    Log.d(LOG_TAG, "start Панки Хой");
                    onPlay(DATA_PANKY, R.string.panky, R.drawable.panky);
                    break;
                case R.id.btnIscatel:
                    Log.d(LOG_TAG, "start Искатель");
                    onPlay(DATA_ISKATEL, R.string.iskatel, R.drawable.iskatel);
                    break;
                case R.id.btnAvto:
                    Log.d(LOG_TAG, "start Avto");
                    onPlay(DATA_AVTO, R.string.avto, R.drawable.avto);
                    break;
                case R.id.btnRetro:
                    Log.d(LOG_TAG, "start Retro");
                    onPlay(DATA_RETRO, R.string.retro, R.drawable.retro);
                    break;
                case R.id.btnZaicev:
                    Log.d(LOG_TAG, "start ZAICEV");
                    onPlay(DATA_ZAICEV, R.string.zaicev, R.drawable.zaicev);
                    break;
                case R.id.btnPioner:
                    Log.d(LOG_TAG, "start Pioner");
                    onPlay(DATA_PIONER, R.string.pioner, R.drawable.pioner);
                    break;
                case R.id.btnUltra:
                    Log.d(LOG_TAG, "start ULTRA");
                    onPlay(DATA_ULTRA, R.string.ultra, R.drawable.ultra);
                    break;
                case R.id.btnSouz:
                    Log.d(LOG_TAG, "start SOUZ");
                    onPlay(DATA_SOUZ, R.string.souz, R.drawable.soyuz_fm);
                    break;
                case R.id.btnChocolad:
                    Log.d(LOG_TAG, "start CHOCOLAD");
                    onPlay(DATA_CHOCOLAD, R.string.chocolate, R.drawable.chocolate);
                    break;
                case R.id.btnDisco_ussr:
                    Log.d(LOG_TAG, "start DISCO_USSR");
                    onPlay(DATA_DISCO_USSR, R.string.diskoteka_sssr, R.drawable.diskoteka_sssr);
                    break;
                case R.id.btnHitFm:
                    Log.d(LOG_TAG, "start HITFM");
                    onPlay(DATA_HITFM, R.string.hitfm, R.drawable.hitfm);
                    break;
                case R.id.btnRomantika:
                    Log.d(LOG_TAG, "start ROMATIKA");
                    onPlay(DATA_ROMATIKA, R.string.romantika, R.drawable.romantika);
                    break;
                case R.id.btnRelax:
                    Log.d(LOG_TAG, "start RELAX");
                    onPlay(DATA_RELAX, R.string.relax, R.drawable.relaxfm);
                    break;
                case R.id.btnRnr:
                    Log.d(LOG_TAG, "start RNR");
                    onPlay(DATA_RNR, R.string.rnr, R.drawable.rock_n_roll_fm);
                    break;
                case R.id.btnUmor:
                    Log.d(LOG_TAG, "start UMOR");
                    onPlay(DATA_UMOR, R.string.umor, R.drawable.umor);
                    break;
                case R.id.btnDor:
                    Log.d(LOG_TAG, "start DOR");
                    onPlay(DATA_DOR, R.string.dor, R.drawable.dor);
                    break;
                case R.id.btnRockstation:
                    Log.d(LOG_TAG, "start ROCKSTATION");
                    onPlay(DATA_ROCKSTATION, R.string.rockstation, R.drawable.rockstation);
                    break;
                case R.id.btnNestandart:
                    Log.d(LOG_TAG, "start NESTANDART");
                    onPlay(DATA_NESTANDART, R.string.nestandart, R.drawable.nestandart);
                    break;

                case R.id.btnR13:
                    Log.d(LOG_TAG, "start 13");
                    onPlay(DATA_R13, R.string.r13, R.drawable.r13);
                    break;

                case R.id.btnShock:
                    Log.d(LOG_TAG, "start SHOCK");
                    onPlay(DATA_SHOCK, R.string.shock, R.drawable.shock);
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
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    progressBar.setVisibility(View.VISIBLE);
                    imageVibor.setVisibility(View.GONE);
                }
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

    void onPlay(String url, int title, int pic) throws IOException {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(url);
        mediaPlayer.setAudioAttributes(
                new AudioAttributes
                        .Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build());
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.prepareAsync();
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setBackgroundResource(pic);
        imageVibor.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        myScroll.scrollTo(0, 0);
        setTitle(title);
        SharedPreferences settings = this.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString( "url", url);
        editor.putInt( "title", title);
        editor.putInt( "pic", pic);
        editor.apply();
        Log.d(LOG_TAG, "записано "+url+" "+getString(title)+" "+getString(pic));
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
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Советую приложение 'Радио Он-Лайн'\nhttps://play.google.com/store/apps/details?id=ru.demonapps.onlineradio");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Поделиться приложением..."));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
