package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class bedroom extends AppCompatActivity {

    public int items_found = 0;
    public int locked = 0;
    ImageButton key;
    ImageView Rashid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_bedroom);

        Rashid = (ImageView) findViewById(R.id.rashid);
        Rashid = (ImageView) findViewById(R.id.rashid);
        Rashid.postDelayed(new Runnable() {
            public void run() {
                Rashid.setImageResource(R.drawable.rashid_dialogue3_2);
                Rashid.postDelayed(new Runnable() {
                    public void run() {
                        Rashid.setVisibility(View.GONE);
                    }
                }, 8000);
            }
        }, 8000);
        Rashid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rashid.setVisibility(View.GONE);
            }
        });

        key = (ImageButton) findViewById(R.id.key);
        ImageButton bullets = (ImageButton) findViewById(R.id.bullets);
        ImageButton bow_tie = (ImageButton) findViewById(R.id.bow_tie);
        ImageButton knife_cloth = (ImageButton) findViewById(R.id.knife_cloth);
        ImageButton blood = (ImageButton) findViewById(R.id.blood);
        ImageView evidences_found = (ImageView)findViewById(R.id.evidences_found);
        evidences_found.setVisibility(View.GONE);

        bullets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bullets.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 4){
                    unlock();
                }
            }
        });
        bow_tie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bow_tie.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 4){
                    unlock();
                }
            }
        });
        knife_cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knife_cloth.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 4){
                    unlock();
                }
            }
        });
        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blood.setVisibility(View.GONE);
                items_found += 1;
                Rashid.setVisibility(View.GONE);
                Rashid.setVisibility(View.VISIBLE);
                Rashid.setImageResource(R.drawable.rashid_dialogue3_6);
                Rashid.postDelayed(new Runnable() {
                    public void run() {
                        Rashid.setVisibility(View.GONE);
                        if(items_found == 4){
                            unlock();
                        }
                    }
                }, 6000);
            }
        });

        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locked == 0) {
                    Rashid.setVisibility(View.GONE);
                    Rashid.setVisibility(View.VISIBLE);
                    Rashid.setImageResource(R.drawable.rashid_dialogue3_3);
                    Rashid.postDelayed(new Runnable() {
                        public void run() {
                            Rashid.setVisibility(View.GONE);
                        }
                    }, 8000);
                }
                else{
                    Rashid.setVisibility(View.GONE);
                    evidences_found.setVisibility(View.VISIBLE);
                    evidences_found.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent proceed = new Intent(bedroom.this,record2.class);
                            proceed.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(proceed);
                        }
                    });
                }
            }
        });

    }
    public void unlock(){
        locked = 1;
        Rashid.setVisibility(View.GONE);
        Rashid.setVisibility(View.VISIBLE);
        Rashid.setImageResource(R.drawable.rashid_dialogue3_4);
        Rashid.postDelayed(new Runnable() {
            public void run() {
                Rashid.setImageResource(R.drawable.rashid_dialogue3_5);
                Rashid.postDelayed(new Runnable() {
                    public void run() {
                        Rashid.setVisibility(View.GONE);
                    }
                }, 8000);
            }
        }, 3000);
    }
    @Override
    public void onBackPressed(){

    }
}