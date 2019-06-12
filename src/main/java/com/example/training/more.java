package com.example.training;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

public class more extends AppCompatActivity {
    MediaPlayer music;

    Button stop;

    ListView lst;

    String[] title = {
            "all_out_of_love",
            "youth",
            "sunset_lover",
            "sacrifice",
            "papa_dont_preach",
            "hope",
            "eastside",
            "old town road",
            "giant"
    };
    String[] artist = {
            "air supply",
            "khalid ft shawn mendez",
            "petit biscuit",
            "elton john",
            "madonna",
            "chainsmokers ft winnoa Oak",
            "khalid and Benny Blanco and Halsey",
            "billy ray cyrus ft lil nas",
            "Calvin harris ft rag n bone man"
    };
    int[] poster = {
            R.drawable.love,
            R.drawable.youth,
            R.drawable.sunset,
            R.drawable.elton,
            R.drawable.madonna,
            R.drawable.hope,
            R.drawable.east,
            R.drawable.horse,
            R.drawable.calvin
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        lst = (ListView) findViewById(R.id.lst);

        List<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();

        for (int x = 0; x < title.length; x += 1) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("header", title[x]);
            hashMap.put("subheading", artist[x]);
            hashMap.put("logo", Integer.toString(poster[x]));

            items.add(hashMap);
        }

        String[] from = {
                "logo",
                "header",
                "subheading",
        };

        int[] to = {
                R.id.img,
                R.id.heading,
                R.id.subheading
        };

        music = new MediaPlayer();


        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), items, R.layout.support, from, to);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.all_out_of_love);
                    music.start();

                }else if (position == 1){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.youth);
                    music.start();
                }else if (position == 2){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.sunset_lover);
                    music.start();
                }else if (position == 3){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.sacrifice);
                    music.start();
                }else if (position == 4){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.papa_dont_preach);
                    music.start();
                }else if (position == 5){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.hope);
                    music.start();
                }else if (position == 6){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.east);
                    music.start();
                }else if (position == 7){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.road);
                    music.start();
                }else if (position == 8){
                    if (music.isPlaying()){
                        music.stop();
                    }
                    music = MediaPlayer.create(getApplicationContext(), R.raw.giant);
                    music.start();
                }
            }
        });

        stop = findViewById(R.id.btnStop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                music.stop();
            }
        });


    }
}
