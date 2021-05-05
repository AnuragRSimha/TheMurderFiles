package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

import java.util.ArrayList;

public class final_level extends AppCompatActivity {

    private VideoView skip_video;
    private VideoView disp_full_detail;
    public String videoPath;
    public int track = 0;
    public int control = 0;
    public int criminal_no = 0;
    public int bool_crim_no = 1;
    ImageButton begin;
    ImageView crim_dets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_final_level);

        crim_dets=(ImageView)findViewById(R.id.crim_dets);
        crim_dets.setVisibility(View.GONE);
        begin = (ImageButton) findViewById(R.id.begin);
        begin.setEnabled(false);
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
        //  View evidences
        ImageButton my_evidences = (ImageButton)findViewById(R.id.my_evidences);
        my_evidences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crim_dets.setImageResource(R.drawable.evidences_found);
                crim_dets.setVisibility(View.VISIBLE);
                crim_dets.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        crim_dets.setVisibility(View.GONE);
                    }
                });
            }
        });

        //  Arrow marks
        ImageView c1_sel = (ImageView)findViewById(R.id.c1_sel);
        ImageView c2_sel = (ImageView)findViewById(R.id.c2_sel);
        ImageView c3_sel = (ImageView)findViewById(R.id.c3_sel);
        ImageView c4_sel = (ImageView)findViewById(R.id.c4_sel);
        ImageView c5_sel = (ImageView)findViewById(R.id.c5_sel);
        ImageView c6_sel = (ImageView)findViewById(R.id.c6_sel);
        c1_sel.setVisibility(View.GONE);
        c2_sel.setVisibility(View.GONE);
        c3_sel.setVisibility(View.GONE);
        c4_sel.setVisibility(View.GONE);
        c5_sel.setVisibility(View.GONE);
        c6_sel.setVisibility(View.GONE);

        //  Crosses
        ImageButton c1_cross = (ImageButton)findViewById(R.id.criminal1_cross);
        ImageButton c2_cross = (ImageButton)findViewById(R.id.criminal2_cross);
        ImageButton c3_cross = (ImageButton)findViewById(R.id.criminal3_cross);
        ImageButton c4_cross = (ImageButton)findViewById(R.id.criminal4_cross);
        ImageButton c5_cross = (ImageButton)findViewById(R.id.criminal5_cross);
        ImageButton c6_cross = (ImageButton)findViewById(R.id.criminal6_cross);
        c1_cross.setVisibility(View.GONE);
        c2_cross.setVisibility(View.GONE);
        c3_cross.setVisibility(View.GONE);
        c4_cross.setVisibility(View.GONE);
        c5_cross.setVisibility(View.GONE);
        c6_cross.setVisibility(View.GONE);

        c1_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 1;
                c1_sel.setVisibility(View.VISIBLE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        c2_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 2;
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.VISIBLE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        c3_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 3;
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.VISIBLE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        c4_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 4;
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.VISIBLE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        c5_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 5;
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.VISIBLE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        c6_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 6;
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.VISIBLE);
            }
        });

        //  Criminal #001
        ImageButton button = (ImageButton) findViewById(R.id.criminal1);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                disp_details(videoView, 1);
                return true;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 1;
                bool_crim_no = 1;
                begin.setEnabled(true);
                c1_sel.setVisibility(View.VISIBLE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.GONE);

            }
        });

        //  Criminal #002
        ImageButton button2 = (ImageButton) findViewById(R.id.criminal2);
        button2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                disp_details(videoView, 2);
                return true;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 2;
                bool_crim_no = 1;
                begin.setEnabled(true);
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.VISIBLE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        //  Criminal #003
        ImageButton button3 = (ImageButton) findViewById(R.id.criminal3);
        button3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                disp_details(videoView, 3);
                return true;
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 3;
                bool_crim_no = 1;
                begin.setEnabled(true);
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.VISIBLE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        //  Criminal #004
        ImageButton button4 = (ImageButton) findViewById(R.id.criminal4);
        button4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                disp_details(videoView, 4);
                return true;
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 4;
                bool_crim_no = 1;
                begin.setEnabled(true);
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.VISIBLE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        //  Criminal #005
        ImageButton button5 = (ImageButton) findViewById(R.id.criminal5);
        button5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                disp_details(videoView, 5);
                return true;
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 5;
                bool_crim_no = 1;
                begin.setEnabled(true);
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.VISIBLE);
                c6_sel.setVisibility(View.GONE);
            }
        });

        //  Criminal #006
        ImageButton button6 = (ImageButton) findViewById(R.id.criminal6);
        button6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                disp_details(videoView, 6);
                return true;
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminal_no = 6;
                bool_crim_no = 1;
                begin.setEnabled(true);
                c1_sel.setVisibility(View.GONE);
                c2_sel.setVisibility(View.GONE);
                c3_sel.setVisibility(View.GONE);
                c4_sel.setVisibility(View.GONE);
                c5_sel.setVisibility(View.GONE);
                c6_sel.setVisibility(View.VISIBLE);
            }
        });

        // remove button
        ImageButton remove = (ImageButton) findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch(criminal_no){
                    case 1: c1_cross.setVisibility(View.VISIBLE);
                            button.setEnabled(false);
                            bool_crim_no = 0;
                            break;
                    case 2: c2_cross.setVisibility(View.VISIBLE);
                            button2.setEnabled(false);
                            bool_crim_no = 0;
                            break;
                    case 3: c3_cross.setVisibility(View.VISIBLE);
                            button3.setEnabled(false);
                            bool_crim_no = 0;
                            break;
                    case 4: c4_cross.setVisibility(View.VISIBLE);
                            button4.setEnabled(false);
                            bool_crim_no = 0;
                            break;
                    case 5: c5_cross.setVisibility(View.VISIBLE);
                            button5.setEnabled(false);
                            bool_crim_no = 0;
                            break;
                    case 6: c6_cross.setVisibility(View.VISIBLE);
                            button6.setEnabled(false);
                            bool_crim_no = 0;
                            break;
                    default: break;
                }
            }
        });

        //  restore button
        ImageButton restore = (ImageButton) findViewById(R.id.restore);
        restore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch(criminal_no){
                    case 1: c1_cross.setVisibility(View.GONE);
                        button.setEnabled(true);
                        bool_crim_no = 1;
                        break;
                    case 2: c2_cross.setVisibility(View.GONE);
                        button2.setEnabled(true);
                        bool_crim_no = 1;
                        break;
                    case 3: c3_cross.setVisibility(View.GONE);
                        button3.setEnabled(true);
                        bool_crim_no = 1;
                        break;
                    case 4: c4_cross.setVisibility(View.GONE);
                        button4.setEnabled(true);
                        bool_crim_no = 1;
                        break;
                    case 5: c5_cross.setVisibility(View.GONE);
                        button5.setEnabled(true);
                        bool_crim_no = 1;
                        break;
                    case 6: c6_cross.setVisibility(View.GONE);
                        button6.setEnabled(true);
                        bool_crim_no = 1;
                        break;
                    default: break;
                }
            }
        });

        //  confirm button
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(criminal_no != 6 && bool_crim_no != 0){
                    Intent game_over = new Intent(final_level.this,game_over.class);
                    game_over.putExtra("criminal_number",String.valueOf(criminal_no));
                    startActivity(game_over);
                }
                else if(criminal_no == 6 && bool_crim_no != 0){
                    Intent game_successfully_over = new Intent(final_level.this,game_successfully_over.class);
                    startActivity(game_successfully_over);
                }
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
                    skip_video.setVisibility(View.GONE);
                    crim_dets.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            crim_dets.setVisibility(View.GONE);
                            begin.setVisibility(View.VISIBLE);
                        }
                    });
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