package com.example.themurderfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class balcony extends AppCompatActivity {

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
        setContentView(R.layout.activity_balcony);

        Rashid = (ImageView) findViewById(R.id.rashid);
        Rashid = (ImageView) findViewById(R.id.rashid);
        Rashid.postDelayed(new Runnable() {
            public void run() {
                Rashid.setImageResource(R.drawable.rashid_dialogue4_1);
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
        ImageButton hook = (ImageButton) findViewById(R.id.hook);
        ImageButton magazine = (ImageButton) findViewById(R.id.rev_magazine);
        ImageButton cigar = (ImageButton) findViewById(R.id.cigar);
        ImageButton blood = (ImageButton) findViewById(R.id.blood);
        ImageButton sickle = (ImageButton) findViewById(R.id.sickle);
        ImageView evidences_found = (ImageView)findViewById(R.id.evidences_found);
        evidences_found.setVisibility(View.GONE);

        hook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hook.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 4){
                    unlock_partial();
                }
                else if(items_found == 5){
                    unlock();
                }
            }
        });
        magazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                magazine.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 4){
                    unlock_partial();
                }
                else if(items_found == 5){
                    unlock();
                }
            }
        });
        cigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cigar.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 4){
                    unlock_partial();
                }
                else if(items_found == 5){
                    unlock();
                }
            }
        });
        sickle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sickle.setVisibility(View.GONE);
                items_found += 1;
                if(items_found == 4){
                    unlock_partial();
                }
                else if(items_found == 5){
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
                Rashid.setImageResource(R.drawable.rashid_dialogue4_2);
                Rashid.postDelayed(new Runnable() {
                    public void run() {
                        Rashid.setVisibility(View.GONE);
                        if(items_found == 4){
                            unlock_partial();
                        }
                        else if(items_found == 5){
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
                    Rashid.setImageResource(R.drawable.rashid_dialogue4_7);
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
                            Intent proceed = new Intent(balcony.this,record3.class);
                            proceed.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(proceed);
                        }
                    });
                }
            }
        });

    }
    public void unlock_partial() {
        Rashid.setVisibility(View.GONE);
        Rashid.setVisibility(View.VISIBLE);
        Rashid.setImageResource(R.drawable.rashid_dialogue4_6);
        Rashid.postDelayed(new Runnable() {
            public void run() {
                Rashid.setImageResource(R.drawable.rashid_dialogue4_5);
                Rashid.postDelayed(new Runnable() {
                    public void run() {
                        Rashid.setVisibility(View.GONE);
                    }
                }, 8000);
            }
        }, 3000);
    }
    public void unlock(){
        locked = 1;
        Rashid.setVisibility(View.GONE);
        Rashid.setVisibility(View.VISIBLE);
        Rashid.setImageResource(R.drawable.rashid_dialogue4_3);
        Rashid.postDelayed(new Runnable() {
            public void run() {
                Rashid.setImageResource(R.drawable.rashid_dialogue4_4);
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