package com.example.training;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class display extends AppCompatActivity {

    VideoView yt;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        yt = (VideoView)findViewById(R.id.youtuber);
        mc = new MediaController(this);

        String videopath = "android.resource://com.example.training/"+R.raw.vida;
        Uri uri = Uri.parse(videopath);
        yt.setVideoURI(uri);
        yt.setMediaController(mc);
        mc.setAnchorView(yt);
        yt.start();

    }
}
