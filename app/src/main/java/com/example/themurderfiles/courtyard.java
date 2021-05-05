package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class courtyard extends AppCompatActivity {

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
        setContentView(R.layout.activity_courtyard);

        Rashid = (ImageView) findViewById(R.id.rashid);
        Rashid.postDelayed(new Runnable() {
            public void run() {
                Rashid.setImageResource(R.drawable.rashid_dialogue2_1);
                Rashid.postDelayed(new Runnable() {
                    public void run() {
                        Rashid.setVisibility(View.GONE);
                    }
                }, 3000);
            }
        }, 8000);
        Rashid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rashid.setVisibility(View.GONE);
            }
        });

        key = (ImageButton) findViewById(R.id.key);
        ImageButton rope = (ImageButton) findViewById(R.id.rope);
        ImageButton lighter = (ImageButton) findViewById(R.id.lighter);
        ImageButton note = (ImageButton) findViewById(R.id.note);
        ImageView evidences_found = (ImageView)findViewById(R.id.evidences_found);
        evidences_found.setVisibility(View.GONE);

        rope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rope.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 3){
                    unlock();
                }
            }
        });
        lighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighter.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 3){
                    unlock();
                }
            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 3){
                    unlock();
                }
            }
        });
        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locked == 0) {
                    Rashid.setVisibility(View.GONE);
                    Rashid.setVisibility(View.VISIBLE);
                    Rashid.setImageResource(R.drawable.rashid_dialogue2_2);
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
                            Intent proceed = new Intent(courtyard.this,record1.class);
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
        Rashid.setImageResource(R.drawable.rashid_dialogue2_3);
        Rashid.postDelayed(new Runnable() {
            public void run() {
                Rashid.setImageResource(R.drawable.rashid_dialogue2_4);
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