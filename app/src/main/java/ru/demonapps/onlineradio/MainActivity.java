package ru.demonapps.onlineradio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import java.io.IOException;

public class MainActivity extends Activity implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener {

    final String LOG_TAG = "myLogs";
    final String DATA_RADIO1 = "http://cdn.radio1.news:8000/rtvp_mp3";
    final String DATA_MENTY = "https://radiomv.hostingradio.ru:80/radiomv128.mp3";
    final String DATA_NASHE = "https://nashe1.hostingradio.ru:80/nashe-128.mp3";
    final String DATA_NASHE20 = "https://nashe1.hostingradio.ru:18000/nashe20-128.mp3";
    final String DATA_COMEDY = "https://ic6.101.ru:8000/stream/air/aac/64/202";
    final String DATA_AVTO = "https://ic7.101.ru:8000/v3_1";
    final String DATA_RETRO = "https://emgregion.hostingradio.ru:8064/moscow.retrofm.mp3";
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
        myScroll= findViewById(R.id.myScroll);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClickStart(View view) {
        releaseMP();

        try {
            switch (view.getId()) {
                case R.id.btnRadio1:
                    Log.d(LOG_TAG, "start RADIO1");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_RADIO1);
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
                    progressBar.setBackgroundResource(R.drawable.podmoskovie);
                    imageVibor.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    myScroll.scrollTo(0,0);
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
                    myScroll.scrollTo(0,0);
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
                    myScroll.scrollTo(0,0);
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
                    myScroll.scrollTo(0,0);
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
                    myScroll.scrollTo(0,0);
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
                    myScroll.scrollTo(0,0);
                    break;
                case R.id.btnDfm:
                    Log.d(LOG_TAG, "start RETRO");
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
                    myScroll.scrollTo(0,0);
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
                myScroll.scrollTo(0,0);
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

}
