package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    int turn = 0;
    public int music_toggle_bool = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        // bgm and entry video
        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.entry_video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setMediaController(null);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, bgm.class);
                startService(intent);
            }
        });
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, bgm.class);
                startService(intent);
            }
        });

        // Watch intro
        ImageButton button = (ImageButton) findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intro = new Intent(MainActivity.this,Intro_Video.class);
//                Intent intro = new Intent(MainActivity.this,final_level.class);
                startActivity(intro);
            }
        });

        // Credits
        ImageButton credits = (ImageButton) findViewById(R.id.credits);
        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("THE CREDITS!!");
                Intent creditts = new Intent(MainActivity.this, credits.class);
                startActivity(creditts);
            }
        });

        // howto
        ImageButton howto = (ImageButton) findViewById(R.id.howto);
        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent howwto = new Intent(MainActivity.this, howto.class);
                startActivity(howwto);
            }
        });

        // toggle music
        ImageButton music_toggle = (ImageButton) findViewById(R.id.music_toggle);
        music_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(music_toggle_bool == 1){
                    music_toggle_bool = 0;
                    stopService(new Intent(MainActivity.this, bgm.class));
                    music_toggle.setImageResource(R.drawable.music_off);
                }
                else{
                    music_toggle_bool = 1;
                    startService(new Intent(MainActivity.this, bgm.class));
                    music_toggle.setImageResource(R.drawable.music_on);
                }
            }
        });
    }
    @Override
    public void onBackPressed(){

    }
}