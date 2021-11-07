package ru.demonapps.onlineradio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;

public class MainActivity extends Activity implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener {

    final String LOG_TAG = "myLogs";

    final String DATA_RADIO1 = "http://cdn.radio1.news:8000/rtvp_mp3";
    final String DATA_MENTY = "https://radiomv.hostingradio.ru:80/radiomv128.mp3";
    final String DATA_NASHE = "https://nashe1.hostingradio.ru:80/nashe-128.mp3";
    final String DATA_NASHE20 = "https://nashe1.hostingradio.ru:18000/nashe20-128.mp3";
    final String DATA_COMEDY = "https://ic6.101.ru:8000/stream/air/aac/64/202";
    MediaPlayer mediaPlayer;
    AudioManager am;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
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
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    Log.d(LOG_TAG, "prepareAsync");
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.podmoskovie);
                    break;
                case R.id.btnMenty:
                    Log.d(LOG_TAG, "start MENTY");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_MENTY);
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    Log.d(LOG_TAG, "prepareAsync");
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.milicia);
                    break;
                case R.id.btnNashe:
                    Log.d(LOG_TAG, "start NASHE");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_NASHE);
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.nashe);
                    break;
                case R.id.btnNashe20:
                    Log.d(LOG_TAG, "start NASHE20");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_NASHE20);
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.nashe20);
                    break;
                case R.id.btnComedy:
                    Log.d(LOG_TAG, "start Comedy");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(DATA_COMEDY);
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setBackgroundResource(R.drawable.comedy);
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
                progressBar.setVisibility(View.INVISIBLE);
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
