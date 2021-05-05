package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class game_over extends AppCompatActivity {

    public String videoPath;
    public int pause_play = 1;
    public int[] crim_array = new int[6];
    public int crime_no;
    VideoView videoView;
    MediaController mediaController;
    ImageButton retry_button;
    ImageButton skip_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_game_over);

        videoView = findViewById(R.id.video_view2);
        retry_button = (ImageButton) findViewById(R.id.retry);
        skip_button = (ImageButton) findViewById(R.id.skip);
        retry_button.setVisibility(View.GONE);
        Intent criminal_number = getIntent();
        String criminal_no = criminal_number.getStringExtra("criminal_number");
        crim_array[0] = 0;
        crim_array[1] = 0;
        crim_array[2] = 0;
        crim_array[3] = 0;
        crim_array[4] = 0;
        crim_array[5] = 0;
//        System.out.println("CRIMINAL_NO = "+criminal_no);
        setvid(criminal_no);
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        skip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                the_end();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                crime_no+=1;
                if(crime_no<6) {
                    System.out.println("crime_no = "+crime_no);
                    int cri_no = getsrc();
                    setvid(String.valueOf(cri_no));
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    mediaController.setAnchorView(videoView);
                    videoView.setMediaController(mediaController);
                    videoView.start();
                }
                else{
                    the_end();
                }

            }
        });
        retry_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retry = new Intent(game_over.this, final_level.class);
                stopService(new Intent(game_over.this, defeat.class));
                startService(new Intent(game_over.this, bgm.class));
                startActivity(retry);
            }
        });
    }
    public int getsrc(){
        int src = 0;
        for(int i = 0; i < 6; i++){
            System.out.println("crim_array["+i+"] = "+crim_array[i]);
            if(crim_array[i]==0){
                crim_array[i] = 1;
                src = i+1;
                break;
            }
        }
        return src;
    }
    public void setvid(String criminal_no){
        switch (criminal_no){
            case "1":   videoPath = "android.resource://" + getPackageName() + "/" + R.raw.rg_intrg;
//                      System.out.println("CRIMINAL: Rajanna Gowda");
                        crim_array[0] = 1;
                        break;
            case "2":   videoPath = "android.resource://" + getPackageName() + "/" + R.raw.hm_intrg;
//                      System.out.println("CRIMINAL: Hakim Massoud");
                        crim_array[1] = 1;
                        break;
            case "3":   videoPath = "android.resource://" + getPackageName() + "/" + R.raw.cs_intrg;
//                      System.out.println("CRIMINAL: Chandra Shetty");
                        crim_array[2] = 1;
                        break;
            case "4":   videoPath = "android.resource://" + getPackageName() + "/" + R.raw.kj_intrg;
//                      System.out.println("CRIMINAL: Kristanna Jasmine");
                        crim_array[3] = 1;
                        break;
            case "5":   videoPath = "android.resource://" + getPackageName() + "/" + R.raw.md_intrg;
//                      System.out.println("CRIMINAL: Mayoori Desai");
                        crim_array[4] = 1;
                        break;
            case "6":   videoPath = "android.resource://" + getPackageName() + "/" + R.raw.mn_intrg;
//                      System.out.println("CRIMINAL: Mailari Nagappa");
                        crim_array[5] = 1;
                        break;
        }
    }
    public void the_end(){
        stopService(new Intent(this, bgm.class));
        startService(new Intent(this, defeat.class));
        skip_button.setVisibility(View.GONE);
        videoPath = "android.resource://" + getPackageName() + "/" + R.raw.game_over;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.stopPlayback();
                videoView.setMediaController(null);
                retry_button.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public void onBackPressed(){

    }
}