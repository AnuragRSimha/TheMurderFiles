package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class hit_list extends AppCompatActivity {

    private VideoView skip_video;
    private VideoView disp_full_detail;
    public String videoPath;
    public int track = 0;
    public int control = 0;
    ImageButton begin;
    ImageView crim_dets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_hit_list);

        crim_dets=(ImageView)findViewById(R.id.crim_dets);
        crim_dets.setVisibility(View.GONE);
        begin = (ImageButton) findViewById(R.id.begin);
        begin.setVisibility(View.GONE);
        ImageView Rashid = (ImageView) findViewById(R.id.rashid);
        Rashid.setVisibility(View.VISIBLE);
        Rashid.postDelayed(new Runnable() {
            public void run() {
                Rashid.setVisibility(View.GONE);
                begin.setVisibility(View.VISIBLE);
            }
        }, 20000);
        Rashid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rashid.setVisibility(View.GONE);
                begin.setVisibility(View.VISIBLE);
            }
        });

        VideoView videoView = findViewById(R.id.video_view);
        //  Criminal #001
        ImageButton button = (ImageButton) findViewById(R.id.criminal1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp_details(videoView, 1);
            }
        });

        //  Criminal #002
        ImageButton button2 = (ImageButton) findViewById(R.id.criminal2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp_details(videoView, 2);
            }
        });

        //  Criminal #003
        ImageButton button3 = (ImageButton) findViewById(R.id.criminal3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp_details(videoView, 3);
            }
        });

        //  Criminal #004
        ImageButton button4 = (ImageButton) findViewById(R.id.criminal4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp_details(videoView, 4);
            }
        });

        //  Criminal #005
        ImageButton button5 = (ImageButton) findViewById(R.id.criminal5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp_details(videoView, 5);
            }
        });

        //  Criminal #006
        ImageButton button6 = (ImageButton) findViewById(R.id.criminal6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp_details(videoView, 6);
            }
        });

        //  Begin the investigation
        begin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent investigate = new Intent(hit_list.this,courtyard.class);
                startActivity(investigate);
            }
        });
    }
    public void disp_details(VideoView videoView, int id) {
        crim_dets=(ImageView)findViewById(R.id.crim_dets);
        switch(id){
            case 1: videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_001;
                    crim_dets.setImageResource(R.drawable.c_001);
                    break;
            case 2: videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_002;
                    crim_dets.setImageResource(R.drawable.c_002);
                    break;
            case 3: videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_003;
                    crim_dets.setImageResource(R.drawable.c_003);
                    break;
            case 4: videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_004;
                    crim_dets.setImageResource(R.drawable.c_004);
                    break;
            case 5: videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_005;
                    crim_dets.setImageResource(R.drawable.c_005);
                    break;
            case 6: videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_006;
                    crim_dets.setImageResource(R.drawable.c_006);
                    break;
        }
        track = 0;
        control = 0;
        begin.setVisibility(View.GONE);
        Uri uri = Uri.parse(videoPath);
        videoView.setVisibility(View.VISIBLE);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setMediaController(null);
        skip_video = (VideoView) findViewById(R.id.video_view);
        skip_video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(control == 1){
                    skip_video.setVisibility(View.GONE);
                    crim_dets.setVisibility(View.GONE);
                    begin.setVisibility(View.VISIBLE);
                }
                else {
                    crim_dets.setVisibility(View.VISIBLE);
                    track += 1;
                    if (track >= 2) {
                        skip_video.setVisibility(View.GONE);
                        crim_dets.setVisibility(View.GONE);
                        begin.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        skip_video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                control = 1;
            }
        });
    }
    @Override
    public void onBackPressed(){

    }
}