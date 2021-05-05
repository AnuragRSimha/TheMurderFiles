package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class game_successfully_over extends AppCompatActivity {

    VideoView videoView;
    ImageButton skip;
    ImageButton to_credits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_game_successfully_over);

        videoView = (VideoView) findViewById(R.id.video_view2);
        skip = (ImageButton) findViewById(R.id.skip);
        to_credits = (ImageButton) findViewById(R.id.to_credits);
        to_credits.setVisibility(View.GONE);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.cut_scene;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        play_cut_scene(videoPath);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                end_game();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end_game();
            }
        });

        to_credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("TO_CREDITS!");
                Intent creditts = new Intent(game_successfully_over.this, credits.class);
                stopService(new Intent(game_successfully_over.this, victory.class));
                startActivity(creditts);
            }
        });
    }
    public void end_game(){
        stopService(new Intent(this, bgm.class));
        startService(new Intent(this, victory.class));
        skip = (ImageButton) findViewById(R.id.skip);
        skip.setVisibility(View.GONE);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.game_successfully_over;
        play_cut_scene(videoPath);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.stopPlayback();
                videoView.setMediaController(null);
                to_credits.setVisibility(View.VISIBLE);
            }
        });
    }
    public void play_cut_scene(String videoPath){
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
    @Override
    public void onBackPressed(){

    }
}