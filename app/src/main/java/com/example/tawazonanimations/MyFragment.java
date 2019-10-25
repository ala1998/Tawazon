package com.example.tawazonanimations;


import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.File;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Environment;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private View gif;
    private SimpleExoPlayer mPlayer;
    private SimpleExoPlayerView mExoView;
    private int currPos = 0, currWindow = 0;
    private boolean whenReady = true;
    private long exoPos = 0;
    private Uri uri;
    private MediaController ctlr;
    public static VideoView video;

    //private MediaPlayer player;
    public MyFragment() {

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //  getActivity().getWindow().setFormat(PixelFormat.TRANSLUCENT);

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final View view = inflater.inflate(R.layout.fragment_my, container, false);
        //     mExoView = view.findViewById(R.id.exo_view);
//        final View placeHolder=(View)view.findViewById(R.id.placeholder);
        File clip = new File(Environment.getExternalStorageDirectory(),
                "/src/raw/" + getArguments().
                        getString("Name") + ".mp4");
/*
        if (clip.exists()) {
            video=(VideoView)view.findViewById(R.id.video);
            video.setVideoPath(clip.getAbsolutePath());

            ctlr=new MediaController(getActivity().getBaseContext());
            ctlr.setMediaPlayer(video);
            video.setMediaController(ctlr);
            video.requestFocus();
       //     video.seekTo(0);
            video.start();
        }
       */
     /*  video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
               // placeHolder.setVisibility(View.GONE);
            }
        });

     */
        uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/raw/" + getArguments().
                getString("Name"));

        video = (VideoView) view.findViewById(R.id.video);

        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/raw/" + getArguments().
                getString("Name"));

        video.setVideoURI(uri);
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setLooping(true);
                // placeHolder.setVisibility(View.GONE);
                DisplayMetrics metrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
                android.widget.RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) video.getLayoutParams();
                params.width = metrics.widthPixels;
                params.height = metrics.heightPixels;
                params.leftMargin = 0;
                video.setLayoutParams(params);
                //mp.start();
                video.start();

            }
        });

        //   initialize(uri);
       /* gif.setBackgroundResource(  getResources().getIdentifier(getArguments().
              getString("Name"),"drawable",getActivity().getPackageName()));*/
       /* Paint paint = new Paint();
        paint.setColor(getContext().getColor(android.R.color.black));

        drawRhombus(new Canvas(), paint, 100, 300, 50);
       */
        return view;


    }
    /*public void drawRhombus(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y + halfWidth); // Top
        path.lineTo(x - halfWidth, y); // Left
        path.lineTo(x, y - halfWidth); // Bottom
        path.lineTo(x + halfWidth, y); // Right
        path.lineTo(x, y + halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }*/

    @Override
    public void onStart() {
        super.onStart();
        // initialize(uri);
    }

    @Override
    public void onResume() {
        super.onResume();
        //initialize(uri);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //   releasePlayer();
    }

    @Override
    public void onPause() {
        super.onPause();
        // if (Util.SDK_INT < 23)
        //   releasePlayer();
    }

    @Override
    public void onStop() {
        super.onStop();
//        if (Util.SDK_INT >= 24)
//            releasePlayer();
    }

  /*  @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            setContentView(Your Landscape layout);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            setContentView(Your portrait layout);
        }
    }*/
}

