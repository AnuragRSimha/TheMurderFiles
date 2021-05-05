package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.VideoView;

public class criminal_1 extends AppCompatActivity {

    private VideoView skip_video;
    String videoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_criminal_1);
        VideoView videoView = findViewById(R.id.video_view);
        Intent get_value = getIntent();
        String val = get_value.getStringExtra("message_key");
        if(val.equals("#001")) {
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_001;
        }
        else if(val.equals("#002")) {
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_002;
        }
        else if(val.equals("#003")) {
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_003;
        }
        else if(val.equals("#004")) {
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_004;
        }
        else if(val.equals("#005")) {
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_005;
        }
        else if(val.equals("#006")) {
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.c_006;
        }
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setMediaController(null);
        skip_video = (VideoView) findViewById(R.id.video_view);
        skip_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intro = new Intent(criminal_1.this,hit_list.class);
                startActivity(intro);
            }
        });
    }
}