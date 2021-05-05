package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class howto extends AppCompatActivity {

    public int next_or_prev = 1;
    ImageView rules;
    ImageButton next;
    ImageButton previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_howto);

        rules = (ImageView) findViewById(R.id.rules);
        next = (ImageButton) findViewById(R.id.next);
        previous = (ImageButton) findViewById(R.id.previous);
        ImageButton exit = (ImageButton) findViewById(R.id.exit);
        previous.setVisibility(View.GONE);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(howto.this, MainActivity.class);
                stopService(new Intent(howto.this,bgm.class));
                startActivity(back);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_or_prev+=1;
                move_back_or_front();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_or_prev-=1;
                move_back_or_front();
            }
        });
    }
    public void move_back_or_front(){
        if(next_or_prev == 1){
            rules.setImageResource(R.drawable.howto_1);
            previous.setVisibility(View.GONE);
        }
        else if(next_or_prev == 2){
            rules.setImageResource(R.drawable.howto_2);
            previous.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
        }
        else if(next_or_prev == 3){
            rules.setImageResource(R.drawable.howto_3);
            next.setVisibility(View.GONE);
        }
    }
}